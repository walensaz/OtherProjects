package GoogleAPI;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.*;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class API {

    private static final String APPLICATION_NAME = "Simple GoogleAPI.API";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials"; // Directory to store user credentials.

    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);


    private static String spreadsheetID = "";

    public API(String spreadsheetID) {
        this.spreadsheetID = spreadsheetID;
    }

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = API.class.getResourceAsStream("client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public void writeTo(List<List<Object>> values, String range) throws IOException, GeneralSecurityException {
        // Build a new authorized GoogleAPI.API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetID, range)
                .execute();

        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetID, range, body).setValueInputOption("RAW")
                        .execute();
    }

    public List<List<Object>> getValues(String range) throws IOException, GeneralSecurityException {
        List<List<Object>> values = null;
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response;
        try {
            response = service.spreadsheets().values()
                    .get(spreadsheetID, range)
                    .execute();
        } catch(GoogleJsonResponseException e) {
            System.out.println("You need to give zsheetsbot@gmail.com access to this sheet.");
            return values;
        }


        List<List<Object>> sheet = response.getValues();
        if (sheet == null || sheet.isEmpty()) {
            System.out.println("No data found.");
            return values;
        }
        return sheet;
    }

    public Object getValue(String cell) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetID, cell)
                .execute();

        List<List<Object>> sheet = response.getValues();
        if(sheet.get(0) == null) {
            return null;
        }
        return sheet.get(0);
    }

    public static List<Object> makeLine(Object... lines) {
        List<Object> data1 = new ArrayList<Object>();
        for(Object s : lines) {
            data1.add(s);
        }
        return data1;
    }

}

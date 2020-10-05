package rts.client.packet.errors;

public enum ErrorCode {
    TAMPERED_PACKET(1, "Tampered Pakcet", "The Server has received a tampered with packet, please retry or contact support if you think this is an error!")
    ;




    ErrorCode(int id, String name, String message) {


    }






}

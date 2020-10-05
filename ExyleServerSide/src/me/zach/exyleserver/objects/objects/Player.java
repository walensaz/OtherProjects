package me.zach.exyleserver.objects.objects;


import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.LoggerLevel;
import me.zach.exyleserver.objects.User;
import me.zach.exyleserver.objects.objects.playerobjects.*;
import me.zach.exyleserver.packet.Packet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Player extends User {

        private int playerId;
        private ArrayList<Packet> packetQueue;

        public boolean addPacketToQueue(Packet packet) {
            if (packetQueue.size() < 40) {
                packetQueue.add(packet);
                return true;
            }
            Logger.log(this.getUsername() + " is overflowing the packet buffer therefore we are removing the last packet!", LoggerLevel.LOW);
            packetQueue.remove(0);
            return false;
        }

        public void processPackets() {
            if (packetQueue.size() > 0) {
                for (Packet packet : packetQueue) {
                    packet.process(this);
                    packetQueue.remove(packet);
                    if (packetQueue.size() <= 0) {
                        break;
                    }
                }
            }
        }




        private static final long serialVersionUID = -942038562193532152L;

        //Nullable
        private PlayerAlliance alliance;

        //NotNull
        private Rank rank;
        private String username;
        private PlayerCastle castle;
        private Hero hero;
        private VIP vip;
        private int kingdom;

        //Resources
        private ConcurrentHashMap<Integer, Resource> resources;
        private Resource gold;

        private Inventory items;
        private long power;
        private boolean hasSecondBuildingQueue;

        private transient Socket socket;
        private transient PrintWriter outputStream;
        private transient BufferedReader inputStream;

        public Player(User user) {
            super(user.getSocket(), user.getUsername(), user.getPassword(), user.getOutputStream(), user.getInputStream());
            this.packetQueue = new ArrayList<>();
            initPlayer(user);
        }

        public void initPlayer(User user) {
            resources = new ConcurrentHashMap<>();
            resources.put(Resource.FOOD, new Resource(10000));
            resources.put(Resource.WOOD, new Resource(10000));
            resources.put(Resource.STONE, new Resource(20000));
            resources.put(Resource.SILVER, new Resource(20000));
            resources.put(Resource.GOLD, new Resource(100));
            this.username = user.getUsername();
            this.castle = new PlayerCastle();
            this.hero = new Hero();
            this.alliance = new PlayerAlliance();
            this.vip = new VIP();
            //this.kingdom = Main.newestkingdom;
            this.items = new Inventory();
            this.power = 1;
            this.hasSecondBuildingQueue = false;
        }


        public ConcurrentHashMap<Integer, Resource> getResources() {
            return resources;
        }

        public void setResources(ConcurrentHashMap<Integer, Resource> resources) {
            this.resources = resources;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


        public PlayerCastle getCastle() {
            return castle;
        }

        public void setCastle(PlayerCastle castle) {
            this.castle = castle;
        }

        public Hero getHero() {
            return hero;
        }

        public void setHero(Hero hero) {
            this.hero = hero;
        }

        public PlayerAlliance getAlliance() {
            return alliance;
        }

        public void setAlliance(PlayerAlliance alliance) {
            this.alliance = alliance;
        }

        public VIP getVip() {
            return vip;
        }

        public void setVip(VIP vip) {
            this.vip = vip;
        }

        public int getKingdom() {
            return kingdom;
        }

        public void setKingdom(int kingdom) {
            this.kingdom = kingdom;
        }

        public Resource getGold() {
            return gold;
        }

        public void setGold(Resource gold) {
            this.gold = gold;
        }

        public Inventory getItems() {
            return items;
        }

        public void setItems(Inventory items) {
            this.items = items;
        }

        public long getPower() {
            return power;
        }

        public void setPower(long power) {
            this.power = power;
        }

        public void setHasSecondBuildingQueue(boolean has) {
            this.hasSecondBuildingQueue = has;
        }

        public boolean hasSecondBuildingQueue() {
            return this.hasSecondBuildingQueue;
        }


        @Override
        public String toString() {
            return ("Player{" +
                    ", alliance=" + alliance +
                    ", username='" + username + '\'' +
                    ", castle=" + castle +
                    ", hero=" + hero +
                    ", vip=" + vip +
                    ", kingdom=" + kingdom +
                    ", resources=" + resources +
                    ", gold=" + gold +
                    ", items=" + items +
                    ", power=" + power +
                    '}');
        }
}

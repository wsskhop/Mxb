package com.example.mxb.data;

public class Ban {
    private int id;
        private String uuid;
            private String name;
                private String ip;
                    private String reason;
                        private String cheatType;
                            private String cheatTypeName;
                                private long startTime;
                                    private long endTime;
                                        private String operatorUuid;
                                            private String operatorName;
                                                private boolean active;
                                                    private String unbannedByUuid;
                                                        private String unbannedByName;
                                                            private long unbanTime;
                                                                private String unbanReason;

                                                                    public int getId() { return id; }
                                                                        public void setId(int id) { this.id = id; }
                                                                            public String getUuid() { return uuid; }
                                                                                public void setUuid(String uuid) { this.uuid = uuid; }
                                                                                    public String getName() { return name; }
                                                                                        public void setName(String name) { this.name = name; }
                                                                                            public String getIp() { return ip; }
                                                                                                public void setIp(String ip) { this.ip = ip; }
                                                                                                    public String getReason() { return reason; }
                                                                                                        public void setReason(String reason) { this.reason = reason; }
                                                                                                            public String getCheatType() { return cheatType; }
                                                                                                                public void setCheatType(String cheatType) { this.cheatType = cheatType; }
                                                                                                                    public String getCheatTypeName() { return cheatTypeName; }
                                                                                                                        public void setCheatTypeName(String cheatTypeName) { this.cheatTypeName = cheatTypeName; }
                                                                                                                            public long getStartTime() { return startTime; }
                                                                                                                                public void setStartTime(long startTime) { this.startTime = startTime; }
                                                                                                                                    public long getEndTime() { return endTime; }
                                                                                                                                        public void setEndTime(long endTime) { this.endTime = endTime; }
                                                                                                                                            public String getOperatorUuid() { return operatorUuid; }
                                                                                                                                                public void setOperatorUuid(String operatorUuid) { this.operatorUuid = operatorUuid; }
                                                                                                                                                    public String getOperatorName() { return operatorName; }
                                                                                                                                                        public void setOperatorName(String operatorName) { this.operatorName = operatorName; }
                                                                                                                                                            public boolean isActive() { return active; }
                                                                                                                                                                public void setActive(boolean active) { this.active = active; }
                                                                                                                                                                    public String getUnbannedByUuid() { return unbannedByUuid; }
                                                                                                                                                                        public void setUnbannedByUuid(String unbannedByUuid) { this.unbannedByUuid = unbannedByUuid; }
                                                                                                                                                                            public String getUnbannedByName() { return unbannedByName; }
                                                                                                                                                                                public void setUnbannedByName(String unbannedByName) { this.unbannedByName = unbannedByName; }
                                                                                                                                                                                    public long getUnbanTime() { return unbanTime; }
                                                                                                                                                                                        public void setUnbanTime(long unbanTime) { this.unbanTime = unbanTime; }
                                                                                                                                                                                            public String getUnbanReason() { return unbanReason; }
                                                                                                                                                                                                public void setUnbanReason(String unbanReason) { this.unbanReason = unbanReason; }
                                                                                                                                                                                                }
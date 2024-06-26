package com.cold.coldlauncher.infrastructure;

public class Player {
    private Icon icon;
    private String name;
    private String uuid;
    public Player(){}

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(this.validateName(name)) {
            this.name = name;
            return true;
        }
        else return false;
    }

    public String getUuid() {
        return uuid;
    }

    public boolean setUuid(String uuid) {
        if(this.validateUUID(uuid)){
            this.uuid = uuid;
            return true;
        }
        else return false;
    }
    public static String removeChar(String str,char c){
        if(!str.contains(Character.toString(c))) return str;
        else {
            String[] tmp = str.split(Character.toString(c));
            StringBuilder ret= new StringBuilder();
            for(int i=0;i<tmp.length;i++){
                ret.append(tmp[i]);
            }
            return ret.toString();
        }
    }
    public static boolean validateName(String name){
        char[] nameCharArray = name.toCharArray();
        int l = name.length();
        if(l<3|l>16) return false;
        else {
            for (int i =0;i<l;i++){
                if(nameCharArray[i]<'a'|nameCharArray[i]>'z'){
                    if(nameCharArray[i]<'A'|nameCharArray[i]>'Z'){
                        if(nameCharArray[i]<'0'|nameCharArray[i]>'9'){
                            if(nameCharArray[i]!='_') return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    public static boolean validateUUID(String uuid){
        uuid=Player.removeChar(uuid,'-');
        char[] id = uuid.toCharArray();
        int l = uuid.length();
        if(l<1|l>32) return false;
        else {
            for (int i=0;i<l;i++){
                if(id[i]<'0'|id[i]>'9'){
                    if(id[i]<'a'|id[i]>'f'){
                        if(id[i]<'A'|id[i]>'F') return false;
                    }
                }
            }
            return true;
        }
    }
}

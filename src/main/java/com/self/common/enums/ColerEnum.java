package com.self.common.enums;
public enum ColerEnum {

    BLUE(1,"blue"),
    RED(2,"red");

    private Integer value;
    private String name;

    private ColerEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public static String values(Integer value){
        for(ColerEnum enumState: ColerEnum.values()){
            if(value.equals(enumState.value)){
                return enumState.name;
            }
        }
        return "";
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

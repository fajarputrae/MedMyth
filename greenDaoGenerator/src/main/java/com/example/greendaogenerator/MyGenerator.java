package com.example.greendaogenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {

    public static void main(String args[]) throws Exception{
        Schema schema = new Schema(1, "com.example.asuspc.medmyths.dao");

        addProfile(schema);

        new DaoGenerator().generateAll(schema, args[0]);
    }

    private static void addProfile(Schema schema) {
        Entity profile = schema.addEntity("Profile");
        profile.setHasKeepSections(true);
        profile.setTableName("Profile");
        profile.addLongProperty("id").primaryKey();
        profile.addStringProperty("name");
        profile.addStringProperty("photo");
    }

}

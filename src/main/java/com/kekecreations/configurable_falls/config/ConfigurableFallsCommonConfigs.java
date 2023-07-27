package com.kekecreations.configurable_falls.config;

import net.minecraftforge.common.ForgeConfigSpec;
public class ConfigurableFallsCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Float> WATER_FALL_DAMAGE_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Float> WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Float> WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Float> WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Float> WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Float> WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ICE_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Float> ICE_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Float> GLASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_PANE_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Float> GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SNOW_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SNOW_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Float> SNOW_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Float> GRASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_TURNS_TO_DIRT_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Float> GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TALL_GRASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TALL_GRASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Float> TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Float> HAY_BALE_FALL_DAMAGE_PERCENTAGE;


    static {
        BUILDER.push("Config for Configurable Falls");

        WATER_FALL_DAMAGE_FALL_DISTANCE = BUILDER
                .comment("Required fall distance for entities to take fall damage in Water! Mod Default : 2.2")
                .define("Water Fall Damage Required Fall Distance", 2.2F);

        WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 1 block deep water!")
                .comment("Value explanation : Only pick values from 0 to 1.  1 = 100% Fall Damage, 0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .define("1 Block Deep Water Fall Damage Percentage", 1F);

        WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 2 block deep water!")
                .comment("Value explanation : Only pick values from 0 to 1.  1 = 100% Fall Damage, 0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .define("2 Block Deep Water Fall Damage Percentages", 0.5F);

        WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 3 block deep water!")
                .comment("Value explanation : Only pick values from 0 to 1.  1 = 100% Fall Damage, 0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .define("3 Block Deep Water Fall Damage Percentages", 0F);

        WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 4 block deep water!")
                .comment("Value explanation : Only pick values from 0 to 1.  1 = 100% Fall Damage, 0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .define("4 Block Deep Water Fall Damage Percentages", 0F);

        WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 5 block deep water and more!")
                .comment("Value explanation : Only pick values from 0 to 1.  1 = 100% Fall Damage, 0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .define("5 Block Deep Water Fall Damage Percentages", 0F);


        ICE_BREAK_ON_FALL = BUILDER
                .comment("Should Ice Break When fallen on?  Vanilla : false   Mod Default : true")
                .define("Ice Break On Fall", true);
        ICE_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for ice to break on fall if Ice Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Ice Break Fall Distance", 2.2F);

        SNOW_BREAK_ON_FALL = BUILDER
                .comment("Should Snow Break When fallen on?  Vanilla : false   Mod Default : true")
                .define("Snow Break On Fall", true);
        SNOW_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Snow to break on fall if Snow Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Snow Break Fall Distance", 2.2F);
        SNOW_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Snow drop snowballs when broken by entities falling on it? Mod Default : false  *Requires Snow Break On Fall to be set to true")
                .define("Snow Drops Snowballs When Broken By Entities Falling On It", false);

        GLASS_BREAK_ON_FALL = BUILDER
                .comment("Should Glass Break When fallen on? (Includes Stained Glass && Tinted Glass) Vanilla : false   Mod Default : true")
                .define("Glass Break On Fall", true);
        GLASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Tinted Glass drop when broken by entities falling on it? Mod Default : true  *Requires Glass Break On Fall to be set to true *If any other mods adds glass drops, glass and stained glass will drop the drops added by that mod when its set to true")
                .define("Tinted Glass Drops Tinted Glass When Broken By Entities Falling On It", true);
        GLASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for glass to break on fall if Glass Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Glass Break Fall Distance", 2.2F);
        GLASS_PANE_BREAK_ON_FALL = BUILDER
                .comment("Should Glass Pane Break When fallen on? (Includes Stained Glass Pane) Vanilla : false   Mod Default : true")
                .define("Glass Pane Break On Fall", true);
        GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for glass pane to break on fall if Glass Pane Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Glass Pane Break Fall Distance", 2.2F);

        HAY_BALE_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take when they fall on Hay Bales.  Vanilla : 0.2. 0.2 = 20% fall damage which is the same as an 80% fall damage reduction")
                .define("Hay Bale Fall Damage Percentage", 0.2F);


        GRASS_BREAK_ON_FALL = BUILDER
                .comment("Should Grass Break When fallen on?  Vanilla : false   Mod Default : true")
                .define("Grass Break On Fall", true);
        GRASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Grass to break on fall if Grass Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Grass Break Fall Distance", 2.2F);
        GRASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Grass have a chance to drop seeds when broken by entities falling on it? Mod Default : true  *Requires Grass Break On Fall to be set to true")
                .define("Grass Has A Chance To Drop Seeds When Broken By Entities Falling On It", true);
        GRASS_TURNS_TO_DIRT_ON_FALL = BUILDER
                .comment("Should Grass turn to dirt when fallen on by an entity?  Mod Default : true")
                .define("Grass Turns To Dirt When Fallen On", true);
        GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Grass to turn to Dirt if Grass Turns To Dirt When Fallen On = true  Mod Default : 2.9    Jumping of 1 block = 2.1")
                .define("Grass Turns To Dirt Fall Distance", 2.9F);
        TALL_GRASS_BREAK_ON_FALL = BUILDER
                .comment("Should Tall Grass Break When fallen on?  Vanilla : false   Mod Default : true")
                .define("Tall Grass Break On Fall", true);
        TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Tall Grass to break on fall if Tall Grass Break On Fall = true, Jumping of 1 block = 2.1")
                .define("Tall Grass Break Fall Distance", 2.9F);
        TALL_GRASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Tall Grass have a chance to drop seeds when broken by entities falling on it? Mod Default : true  *Requires Tall Grass Break On Fall to be set to true")
                .define("Tall Grass Has A Chance To Drop Seeds When Broken By Entities Falling On It", true);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}

package com.kekecreations.configurable_falls.config;

import net.minecraftforge.common.ForgeConfigSpec;
public class ConfigurableFallsCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> WATER_FALL_DAMAGE_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Double> WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Double> WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Double> WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Double> WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ICE_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Double> ICE_BREAK_ON_FALL_FALL_DISTANCE;


    public static final ForgeConfigSpec.ConfigValue<Boolean> MELON_EXPLODE_INTO_SLICES_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Double> MELON_EXPLODE_INTO_SLICES_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Double> GLASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GLASS_PANE_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Double> GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SNOW_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SNOW_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Double> SNOW_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> LEAVES_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> LEAVES_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Double> LEAVES_BREAK_ON_FALL_FALL_DISTANCE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Double> GRASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GRASS_TURNS_TO_DIRT_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Double> GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TALL_GRASS_BREAK_ON_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TALL_GRASS_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Double> TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> HAY_BALE_FALL_DAMAGE_PERCENTAGE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS;
    public static final ForgeConfigSpec.ConfigValue<Double> CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE;


    static {
        BUILDER.push("Config for Configurable Falls");

        WATER_FALL_DAMAGE_FALL_DISTANCE = BUILDER
                .comment("Required fall distance for entities to take fall damage in Water! Mod Default : 2.2")
                .defineInRange("Water Fall Damage Required Fall Distance", 2.2, 0.0, 256.0);

        WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 1 block deep water! (Uses #configurable_falls:water fluid tag)")
                .comment("Value explanation : 1.0 = 100% Fall Damage, 0.0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .defineInRange("1 Block Deep Water Fall Damage Percentage", 1.0, 0.0, 1.0);

        WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 2 block deep water! (Uses #configurable_falls:water fluid tag)")
                .comment("Value explanation : 1.0 = 100% Fall Damage, 0.0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .defineInRange("2 Block Deep Water Fall Damage Percentages", 0.5, 0.0, 1.0);

        WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 3 block deep water! (Uses #configurable_falls:water fluid tag)")
                .comment("Value explanation : 1.0 = 100% Fall Damage, 0.0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .defineInRange("3 Block Deep Water Fall Damage Percentages", 0.0, 0.0, 1.0);

        WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 4 block deep water! (Uses #configurable_falls:water fluid tag)")
                .comment("Value explanation : 1.0 = 100% Fall Damage, 0.0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .defineInRange("4 Block Deep Water Fall Damage Percentages", 0.0, 0.0, 1.0);

        WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take in 5 block deep water and more! (Uses #configurable_falls:water fluid tag)")
                .comment("Value explanation : 1.0 = 100% Fall Damage, 0.0 = 0% Fall Damage, 0.5 = 50% Fall Damage, 0.7 = 70% Fall Damage which is the same as a 30% Fall Damage Reduction")
                .defineInRange("5 Block Deep Water Fall Damage Percentages", 0.0, 0.0, 1.0);


        ICE_BREAK_ON_FALL = BUILDER
                .comment("Should Ice Break When fallen on? Mod Default : true (Uses #configurable_falls:ice block tag)")
                .define("Ice Break On Fall", true);
        ICE_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for ice to break on fall if Ice Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Ice Break Fall Distance", 2.2, 0.0, 256.0);

        SNOW_BREAK_ON_FALL = BUILDER
                .comment("Should Snow Break When fallen on? Mod Default : true (Uses #configurable_falls:snow block tag)")
                .define("Snow Break On Fall", true);
        SNOW_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Snow to break on fall if Snow Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Snow Break Fall Distance", 2.2, 0.0, 256.0);
        SNOW_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Snow drop Snowballs when broken by entities falling on it? Mod Default : false  *Requires Snow Break On Fall to be set to true")
                .define("Snow Drop Items When Broken By Entities Falling On It", false);

        GLASS_BREAK_ON_FALL = BUILDER
                .comment("Should Glass Break When fallen on? Mod Default : true (Uses #forge:glass block tag)")
                .define("Glass Break On Fall", true);
        GLASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Tinted Glass drop when broken by entities falling on it? Mod Default : true  *Requires Glass Break On Fall to be set to true *If any other mods adds glass drops, glass and stained glass will drop the drops added by that mod when its set to true")
                .define("Tinted Glass Drops Tinted Glass When Broken By Entities Falling On It", true);
        GLASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for glass to break on fall if Glass Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Glass Break Fall Distance", 2.2, 0.0, 256.0);
        GLASS_PANE_BREAK_ON_FALL = BUILDER
                .comment("Should Glass Pane Break When fallen on? Mod Default : true (Uses #forge:glass_panes tag)")
                .define("Glass Pane Break On Fall", true);
        GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for glass pane to break on fall if Glass Pane Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Glass Pane Break Fall Distance", 2.2, 0.0, 256.0);

        HAY_BALE_FALL_DAMAGE_PERCENTAGE = BUILDER
                .comment("How much fall damage entities will take when they fall on Hay Bales.  Vanilla : 0.2. 0.2 = 20% fall damage which is the same as a 80% fall damage reduction")
                .defineInRange("Hay Bale Fall Damage Percentage", 0.2, 0.0, 1.0);


        GRASS_BREAK_ON_FALL = BUILDER
                .comment("Should Grass Break When fallen on? Mod Default : true (Uses #configurable_falls:grass block tag)")
                .define("Grass Break On Fall", true);
        GRASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Grass to break on fall if Grass Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Grass Break Fall Distance", 2.2, 0.0, 256.0);
        GRASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Grass have a chance to drop seeds when broken by entities falling on it? Mod Default : true  *Requires Grass Break On Fall to be set to true")
                .define("Grass Has A Chance To Drop Seeds When Broken By Entities Falling On It", true);
        GRASS_TURNS_TO_DIRT_ON_FALL = BUILDER
                .comment("Should Grass turn to dirt when fallen on by an entity? Mod Default : true (Uses #configurable_falls:grass_blocks block tag)")
                .define("Grass Turns To Dirt When Fallen On", true);
        GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Grass to turn to Dirt if Grass Turns To Dirt When Fallen On = true  Mod Default : 2.9    Jumping of 1 block = 2.1")
                .defineInRange("Grass Turns To Dirt Fall Distance", 2.9, 0.0, 256.0);
        TALL_GRASS_BREAK_ON_FALL = BUILDER
                .comment("Should Tall Grass Break When fallen on? Mod Default : true (Uses #configurable_falls:tall_grass block tag)")
                .define("Tall Grass Break On Fall", true);
        TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Tall Grass to break on fall if Tall Grass Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Tall Grass Break Fall Distance", 2.9, 0.0, 256.0);
        TALL_GRASS_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Tall Grass have a chance to drop seeds when broken by entities falling on it? Mod Default : true  *Requires Tall Grass Break On Fall to be set to true")
                .define("Tall Grass Has A Chance To Drop Seeds When Broken By Entities Falling On It", true);

        CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Blocks that have the #fragile tag to break on fall, Jumping of 1 block = 2.1")
                .defineInRange("Blocks With #fragile Required Fall Distance For Block To Break", 2.2, 0.0, 256.0);
        CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Blocks that have the #fragile tag drop their block drops. Mod Default : true ")
                .define("Blocks With #fragile tag drop loot", true);



        MELON_EXPLODE_INTO_SLICES_ON_FALL = BUILDER
                .comment("Should Melon Explode Into Melon Slices When fallen on? Mod Default : true (Uses #configurable_falls:melon_blocks block tag)")
                .define("Melon Explode Into Melon Slices On Fall", true);
        MELON_EXPLODE_INTO_SLICES_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for melon to explode on fall if Melon Explode Into Melon Slices On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Melon Explode Into Melon Slices Fall Distance", 2.2, 0.0, 256.0);

        LEAVES_BREAK_ON_FALL = BUILDER
                .comment("Should Leaves Break When fallen on? Mod Default : false (Uses #minecraft:leaves block tag)")
                .define("Leaves Break On Fall", false);
        LEAVES_BREAK_ON_FALL_FALL_DISTANCE = BUILDER
                .comment("Required Fall Distance for Leaves to break on fall if Leaves Break On Fall = true, Jumping of 1 block = 2.1")
                .defineInRange("Leaves Break Fall Distance", 2.2, 0.0, 256.0);
        LEAVES_BREAK_ON_FALL_DROPS = BUILDER
                .comment("Should Leaves drop Apples, Saplings and Sticks when broken by entities falling on it? Mod Default : false  *Requires Leaves Break On Fall to be set to true")
                .define("Leaves Drop Items When Broken By Entities Falling On It", false);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}

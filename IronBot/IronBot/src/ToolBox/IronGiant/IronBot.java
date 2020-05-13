package ToolBox.IronGiant;

import javax.security.auth.login.LoginException;

import ToolBox.IronGiant.Events.GuildMemberJoin;
import ToolBox.IronGiant.Events.GuildMemberLeave;
import ToolBox.IronGiant.Events.GuildMessageReactionAdd;
import ToolBox.IronGiant.Events.GuildMessageReceived;
import commands.Clear;
import commands.Commands;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class IronBot {
    public static JDA jda;
    public static String prefix = "~";

    // Main method
    public static void main(String[] args) throws LoginException {

        jda = new JDABuilder(AccountType.BOT).setToken("NzAxOTMxODA5MDYzMzA1MzI3.Xrsy-A.y7y0A2dh4uzyEV0lzxP0J4m5Nkw")
            .build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching(
            "Myself being created. Hi! I'm IronBot, I am a discord bot created by my masters for their CMPE133 Final Project"));

        jda.addEventListener(new Commands());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new GuildMessageReceived());
        jda.addEventListener(new Clear());
        jda.addEventListener(new GuildMessageReactionAdd());

    }
}
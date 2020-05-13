package ToolBox.IronGiant;

import javax.security.auth.login.LoginException;

import ToolBox.IronGiant.Events.GuildMemberJoin;
import ToolBox.IronGiant.Events.GuildMemberLeave;
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

        jda = new JDABuilder(AccountType.BOT).setToken("NzAxOTMxODA5MDYzMzA1MzI3.Xp5Ryg.i3PTHeNBpa7nbX9zpCQmKiSzcPY")
            .build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("Group8 create their project..."));

        jda.addEventListener(new Commands());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
    }
}
package commands;

import java.util.List;

import ToolBox.IronGiant.IronBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase(IronBot.prefix + "test")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("🐱‍🏍IronBot");
			info.setDescription("Not sure what to put here yet");
			info.setColor(0xf45642);
			info.setFooter("Created by the best", event.getMember().getUser().getAvatarUrl());

			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}

package ToolBox.IronGiant.Events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

	String[] messages = { 
			"A wild [member] appeared.",
			"[member] joined. Be careful of what you say and do.",
			"Watch out! [member] is here to spy on you!", 
			"Hey! [member] has joined!",
			"Haha.. [member] is going to regret joining this server. ", 
			"Welcome [member], we have been expecting you for some time now.",
			"Dear [member], you are unwelcomed here.", 
			"[member] is now here, please evacuate the server.",
			"[member] has joined... but who are you?"
			};

	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Random rand = new Random();
		int number = rand.nextInt(messages.length);

		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0x66d8ff);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

		// Add role
		event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Member", true))
				.complete();
	}
}

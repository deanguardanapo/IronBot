package ToolBox.IronGiant.Events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		event.getMessage().addReaction("❌").queue();
	}
}

/*	
		if (args[0].equalsIgnoreCase("test")) {
			
			// Get channel name and send in current channel
			String channelName = event.getChannel().getName();
			event.getChannel().sendMessage(channelName).queue();
			
			// Upload and send an image to current channel
			try {
				URL url = new URL("https://i.imgur.com/Jc4HEGN.jpg");
				BufferedImage img = ImageIO.read(url);
				File file = new File("temp.jpg"); // change the '.jpg' to whatever extension the image has
				ImageIO.write(img, "jpg", file); // again, change 'jpg' to the correct extension
				event.getChannel().sendFile(file).queue();
			}
			catch (Exception e) {
				event.getChannel().sendMessage("Error fetching image.").queue();
			}
		}
		
		if (args[0].equalsIgnoreCase("~mute")) {
			if (args.length > 1 && args.length < 3) {
				Member member = event.getGuild().getMemberById(args[1].replace("<@", "").replace(">", ""));
				Role role = event.getGuild().getRoleById("707088676445749309");
				
				if (!member.getRoles().contains(role)) {
					// Mute user
					event.getChannel().sendMessage("Muted " + args[1] + ".").queue();
					event.getGuild().getController().addRolesToMember(member, role).complete();
				}
				else {
					// Unmute user
					event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
					event.getGuild().getController().removeRolesFromMember(member, role).complete();
				}
			}
			else if (args.length == 3) {
				Member member = event.getGuild().getMemberById(args[1].replace("<@", "").replace(">", ""));
				Role role = event.getGuild().getRoleById("707088676445749309");
				
				event.getChannel().sendMessage("Muted " + args[1] + " for " + args[2] + " seconds.").queue();
				event.getGuild().getController().addRolesToMember(member, role).complete();
				
				// Unmute after a few seconds
				new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
							event.getGuild().getController().removeRolesFromMember(member, role).complete();
						}
					},
					Integer.parseInt(args[2]) * 1000
				);
			}
			else {
				event.getChannel().sendMessage("Incorrect syntax. Use `~mute [user mention] [time {optional}]`").queue();
			}
		}
	}
}
		*/
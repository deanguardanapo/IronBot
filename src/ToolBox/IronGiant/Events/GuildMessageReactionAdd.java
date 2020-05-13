package ToolBox.IronGiant.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (event.getReactionEmote().getName().contentEquals("❌") &&
            !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
            if (event.getMember().getUser().equals(event.getChannel().retrieveMessageById(event.getMessageId()).complete().getAuthor())) {
                //delete message if it is the author
                event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
            }
        } else {
            //if not author
            event.getReaction().removeReaction().queue();
        }
    }

}
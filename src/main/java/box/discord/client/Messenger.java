package box.discord.client;

import box.discord.result.Option;
import box.discord.result.Result;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;

import java.io.File;
import java.util.EnumSet;

public interface Messenger {
    
    Result sendMessage(IChannel channel, String message);

    Result sendQuoteMessage(IChannel channel, String message);

    Result uploadFile(IChannel channel, File file);

    Option<IChannel> createChannel(IGuild guild, String channelName);

    Result addChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions);

    Result removeChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions);

    Result removeChannel(IChannel channel);
}

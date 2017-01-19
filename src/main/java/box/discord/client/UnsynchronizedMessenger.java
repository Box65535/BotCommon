package box.discord.client;

import box.discord.result.Option;
import box.discord.result.Result;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.MessageBuilder;

import java.io.File;
import java.util.EnumSet;

public class UnsynchronizedMessenger implements Messenger {

    private static final EnumSet<Permissions> EMPTY_SET = EnumSet.noneOf(Permissions.class);
    
    private IDiscordClient client;

    public UnsynchronizedMessenger(IDiscordClient client) {
        this.client = client;
    }

    public Result sendMessage(IChannel channel, String message) {
        try {
            channel.sendMessage(message);
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Result sendQuoteMessage(IChannel channel, String message) {
        try {
            new MessageBuilder(client).withChannel(channel).withQuote(message).send();
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Result uploadFile(IChannel channel, File file) {
        try {
            channel.sendFile(file);
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Option<IChannel> createChannel(IGuild guild, String channelName) {
        try {
            return Result.Success(guild.createChannel(channelName));
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Result removeChannel(IChannel channel) {
        try {
            channel.delete();
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Result addChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions) {
        try {
            channel.overrideRolePermissions(role, permissions, EMPTY_SET);
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }

    public Result removeChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions) {
        try {
            channel.overrideRolePermissions(role, permissions, EMPTY_SET);
            return Result.Success();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.Failure(e);
        }
    }
}

package box.discord.client;

import box.discord.result.Option;
import box.discord.result.Result;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;

import java.io.File;
import java.util.EnumSet;

public class SynchronizedMessenger implements Messenger {
    
    private UnsynchronizedMessenger delegate;

    public SynchronizedMessenger(IDiscordClient client) {
        this.delegate = new UnsynchronizedMessenger(client);
    }

    public Result sendMessage(IChannel channel, String message) {
        synchronized (this) {
            return delegate.sendMessage(channel, message);
        }
    }

    public Result sendQuoteMessage(IChannel channel, String message) {
        synchronized (this) {
            return delegate.sendQuoteMessage(channel, message);
        }
    }

    public Result uploadFile(IChannel channel, File file) {
        synchronized (this) {
            return delegate.uploadFile(channel, file);
        }
    }

    public Option<IChannel> createChannel(IGuild guild, String channelName) {
        synchronized (this) {
            return delegate.createChannel(guild, channelName);
        }
    }

    public Result removeChannel(IChannel channel) {
        synchronized (this) {
            return delegate.removeChannel(channel);
        }
    }

    public Result addChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions) {
        synchronized (this) {
            return delegate.addChannelPermissions(channel, role, permissions);
        }
    }

    public Result removeChannelPermissions(IChannel channel, IRole role, EnumSet<Permissions> permissions) {
        synchronized (this) {
            return delegate.removeChannelPermissions(channel, role, permissions);
        }
    }
}

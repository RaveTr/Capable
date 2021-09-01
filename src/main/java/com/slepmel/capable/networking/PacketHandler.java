package com.slepmel.capable.networking;

import com.slepmel.capable.Capable;

import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
	
	    private static final String PROTOCOL_VERSION = "1";
	    public static final SimpleChannel CHANNEL = NetworkRegistry
	            .newSimpleChannel(Capable.locPrefix("channel"),
	                    () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	    public static void init() {
	        int id = 0;
	        CHANNEL.messageBuilder(PacketThrowPlayer.class, id++).encoder(PacketThrowPlayer::encode)
	                .decoder(PacketThrowPlayer::new).consumer(PacketThrowPlayer.Handler::onMessage).add();
	    }

}

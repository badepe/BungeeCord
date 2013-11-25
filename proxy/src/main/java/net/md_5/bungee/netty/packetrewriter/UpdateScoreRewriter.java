package net.md_5.bungee.netty.packetrewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.netty.Var;

public class UpdateScoreRewriter extends PacketRewriter {

    @Override
    public void rewriteClientToServer(ByteBuf in, ByteBuf out)
    {
        unsupported( true );
    }

    @Override
    public void rewriteServerToClient(ByteBuf in, ByteBuf out)
    {
        String itemName = Var.readString( in, false );
        byte updateRemove = in.readByte();
        String scoreboardName = Var.readString( in, false );
        int value = in.readInt();
        Var.writeString( itemName, out, true );
        out.writeByte( updateRemove );
        Var.writeString( scoreboardName, out, true );
        out.writeInt( value );
    }

}

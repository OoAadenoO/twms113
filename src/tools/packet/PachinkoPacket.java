package tools.packet;

import handling.SendPacketOpcode;
import tools.data.MaplePacketLittleEndianWriter;

/**
 * Created by Toby on 2016/8/31.
 */
public class PachinkoPacket {

    public static byte[] marqueeMessage(String playerName) {
        MaplePacketLittleEndianWriter writer = new MaplePacketLittleEndianWriter();
        writer.writeShort(SendPacketOpcode.PACHINKO_MARQUEE.getValue());
        writer.writeInt(1);
        writer.writeMapleAsciiString(playerName);
        return writer.getPacket();
    }

    public static byte[] showPachinko(int beansCount) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(SendPacketOpcode.PACHINKO_SHOW.getValue());
        mplew.writeInt(beansCount);
        return mplew.getPacket();
    }

    public static byte[] setLightLevel(int light)
    {
        MaplePacketLittleEndianWriter writer = new MaplePacketLittleEndianWriter();
        writer.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        writer.write(3);
        writer.write(light);
        return writer.getPacket();
    }

    public static byte[] spinTest(int light)
    {
        MaplePacketLittleEndianWriter writer = new MaplePacketLittleEndianWriter();
        writer.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        writer.write(4);
        writer.write(light);
        writer.write(1); // x
        writer.write(2); // z
        writer.write(3); // y
        writer.write(1); // Helper
        writer.write(0xFF);
        writer.writeInt(1);
        writer.write(1);
        return writer.getPacket();
    }

    public static byte[] rewardBalls(int ballsCount, int openStage)
    {
        MaplePacketLittleEndianWriter writer = new MaplePacketLittleEndianWriter();
        writer.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        writer.write(5);
        writer.writeInt(ballsCount);
        writer.write(openStage);
        return writer.getPacket();
    }

    public static byte[] rewardBalls(int ballsCount)
    {
        return rewardBalls(ballsCount, 0);
    }

    public static byte[] exitPachinko()
    {
        MaplePacketLittleEndianWriter writer = new MaplePacketLittleEndianWriter();
        writer.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        writer.write(6);
        return writer.getPacket();
    }

    public static byte[] updateBalls(int cid, int beansCount) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(SendPacketOpcode.UPDATE_BEANS.getValue());
        mplew.writeInt(cid);
        mplew.writeInt(beansCount);
        mplew.writeInt(0);
        return mplew.getPacket();
    }

}

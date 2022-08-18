/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Yakup
 */
/*class ReadAja {
    
    DxfEssi buffer=new DxfEssi();
public ArrayList<DxfEssi> essivect=new ArrayList<>(); 

public ReadAja(String ajaFileName)
{
    
    

}
}*/

import java.io.*;

/**
 * Replacement for a DataInputStream that provides both little and big endian reading capabilities for convenience without need to implement a ByteBuffer
 * @author Bill (unspecified.specification@gmail.com)
 */
//public class EndianInputStream extends InputStream implements DataInput {
public class ReadAja extends InputStream implements DataInput {
    private DataInputStream dataInStream;
    private InputStream inStream;
    private byte byteBuffer[];
    
DxfEssi buffer=new DxfEssi();
public ArrayList<DxfEssi> essivect=new ArrayList<>(); 
//DxfEssi vect




DxfEssi assignto() throws IOException{
DxfEssi temp = new DxfEssi();

temp.oge.indx=readLittleShort();
temp.oge.atrib=readLittleShort();
temp.oge.radius=readLittleDouble();//*100*(1+24.4*ajanframe.MetricInc);

temp.oge.xn1=readLittleDouble();
temp.oge.yn1=readLittleDouble();
temp.oge.an1=readLittleDouble();
temp.oge.xn2=readLittleDouble();
temp.oge.yn2=readLittleDouble();
temp.oge.an2=readLittleDouble();

//temp.Flags.G40=readBoolean();

//byte oku= (byte) read();
/*if((oku&1)==1)temp.Flags.G40=true;
if((oku&2)==2)temp.Flags.G41=true;
if((oku&3)==3)temp.Flags.G42=true;
if((oku&4)==4)temp.Flags.PlasmaEnable=true;
if((oku&5)==5)temp.Flags.MarkingEnable=true;
if((oku&6)==6)temp.Flags.PlasmaCut=true;
if((oku&7)==7)temp.Flags.MarkingCut=true;
if((oku&8)==8)temp.Flags.RapidOn=true;*/
//oku= (byte) read();oku= (byte) read();oku= (byte) read();oku= (byte) read();oku= (byte) read();oku= (byte) read();
//float test=readLittleFloat();
//long oku=readLittleInt();
byte oku= (byte) read();
if((oku&1)!=0)temp.Flags.G40=true;
if((oku&2)!=0)temp.Flags.G41=true;
if((oku&4)!=0)temp.Flags.G42=true;
if((oku&8)!=0)temp.Flags.PlasmaEnable=true;
if((oku&16)!=0)temp.Flags.MarkingEnable=true;
if((oku&32)!=0)temp.Flags.PlasmaCut=true;
if((oku&64)!=0)temp.Flags.MarkingCut=true;
if((oku&128)!=0)temp.Flags.RapidOn=true;
oku= (byte) read();
if((oku&1)!=0)temp.Flags.FeedFlag=true;
if((oku&2)!=0)temp.Flags.KerfFlag=true;
if((oku&4)!=0)temp.Flags.SkipFlag=true;
//if((oku&8)!=0)temp.Flags.IlaveFlag=true;
if((oku&16)!=0)temp.Flags.LeadInFlag=true;
if((oku&32)!=0)temp.Flags.LeadOutFlag=true;
if((oku&64)!=0)temp.Flags.MiddleSideBevelCutisLegal=true;
if((oku&128)!=0)temp.Flags.BottomSideBevelCutisLegal=true;
oku= (byte) read();
if((oku&1)!=0)temp.Flags.TopSideBevelCutisLegal=true;
if((oku&2)!=0)temp.Flags.BeLastCut=true;
if((oku&4)!=0)temp.Flags.SmallHole=true;

//if((oku&8)!=0)temp.Flags.CutType=true;  CUTTYPE
//if((oku&16)!=0)temp.Flags.AngleTakenFlg=true;
if((oku&32)!=0)temp.Flags.AngleTakenFlg=true;
if((oku&64)!=0)temp.Flags.PiercingWith90DegreeCancel=true;
if((oku&128)!=0)temp.Flags.BevelCornerThcCancel=true;

oku= (byte) read();
if((oku&1)!=0)temp.Flags.BevelCornerF=true;
//if((oku&2)!=0)temp.Flags.skipActive=true;
if((oku&4)!=0)temp.Flags.KulakFlag=true;
//if((oku&8)!=0)temp.Flags.G42=true;
//if((oku&16)!=0)temp.Flags.PlasmaEnable=true;
//if((oku&32)!=0)temp.Flags.MarkingEnable=true;
//if((oku&64)!=0)temp.Flags.PlasmaCut=true;
//if((oku&128)!=0)temp.Flags.MarkingCut=true;





temp.FeedRate=readLittleShort();//(int)(vect.FeedRate/2.5);
temp.KerfWidth=readLittleFloat();

temp.oge.StartAngle=readLittleDouble();
temp.oge.EndAngle=readLittleDouble();

temp.TopSideBevelAngle=readLittleDouble();
temp.TopSideBevelHeight=readLittleShort();
temp.MiddleSideBevelHeight=readLittleShort();
temp.BottomSideBevelHeight=readLittleShort();
temp.BottomSideBevelAngle=readLittleShort();
//temp.oge.SetAngle();
//if(temp.oge.indx==2||temp.oge.indx==3){
temp.oge.SetCenter();
temp.oge.SetAngle();
temp.oge.SetRadius();


//temp.oge.SetAngle();}
//temp=buff_yaz(temp);

/*dxfcnv dxfc=new dxfcnv();
dxfc.xn1=temp.oge.xn1;
dxfc.yn1=temp.oge.yn1;
dxfc.an1=temp.oge.an1;
dxfc.xn2=temp.oge.xn2;
dxfc.yn2=temp.oge.yn2;
dxfc.an2=temp.oge.an2;
dxfc.radius=temp.oge.radius;
dxfc.StartAngle=temp.oge.StartAngle;
dxfc.EndAngle=temp.oge.EndAngle;
dxfc.indx=temp.oge.indx;
dxfc.atrib=temp.oge.atrib;
dxfc.SetCenter();
//dxfc.SetAngle();
dxfc.SetRadius();*/
temp.oge.xc=temp.oge.xc*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yc=temp.oge.yc*100*(1+24.4*ajanframe.MetricInc);
temp.oge.ac=temp.oge.ac*100*(1+24.4*ajanframe.MetricInc);
temp.oge.radius=temp.oge.radius*100*(1+24.4*ajanframe.MetricInc);
temp.oge.xn1=temp.oge.xn1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn1=temp.oge.yn1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.an1=temp.oge.an1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.xn2=temp.oge.xn2*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn2=temp.oge.yn2*100*(1+24.4*ajanframe.MetricInc);
temp.oge.an2=temp.oge.an2*100*(1+24.4*ajanframe.MetricInc);
 temp.Flags.G41=true;
/*
temp.oge.EndAngle=vect.oge.EndAngle;
temp.oge.StartAngle=vect.oge.StartAngle;
temp.oge.radius=vect.oge.radius*1000*(1+24.4*ajanframe.MetricInc);
temp.oge.xc=vect.oge.xc*1000*(1+24.4*ajanframe.MetricInc);
temp.oge.xn1=((vect.oge.xn1*1.746)/2)*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yc=vect.oge.yc*1000*(1+24.4*ajanframe.MetricInc);
temp.oge.xn2=((vect.oge.xn2*1.746)/2)*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn1=vect.oge.yn1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn2=vect.oge.yn2*100*(1+24.4*ajanframe.MetricInc);
temp.oge.ac=vect.oge.ac*(1+24.4*ajanframe.MetricInc);
temp.oge.an1=vect.oge.an1*13.888889*(1+24.4*ajanframe.MetricInc);
temp.oge.an2=vect.oge.an2*13.888889*(1+24.4*ajanframe.MetricInc);
temp.oge.zn1=vect.oge.zn1*250*(1+24.4*ajanframe.MetricInc);
temp.oge.zn2=vect.oge.zn2*250*(1+24.4*ajanframe.MetricInc);
temp.vn1=vect.vn1*100*(1+24.4*ajanframe.MetricInc);
temp.vn2=vect.vn2*100*(1+24.4*ajanframe.MetricInc);
temp.wn1=vect.wn1*100*(1+24.4*ajanframe.MetricInc);
temp.wn2=vect.wn2*100*(1+24.4*ajanframe.MetricInc);


temp.BottomSideBevelAngle=vect.BottomSideBevelAngle;
temp.Flags.AngleTakenFlg=vect.Flags.AngleTakenFlg;
temp.Flags.A400Flag=vect.Flags.A400Flag;
temp.Flags.BeLastObject=vect.Flags.BeLastObject;
temp.Flags.BevelCornerF=vect.Flags.BevelCornerF;

temp.Flags.BevelCornerThcCancel=vect.Flags.BevelCornerThcCancel;
temp.Flags.BottomSideBevelCutisLegal=vect.Flags.BottomSideBevelCutisLegal;
temp.Flags.CutType=vect.Flags.CutType;
temp.Flags.FeedFlag=vect.Flags.FeedFlag;
temp.Flags.G40=vect.Flags.G40;
temp.Flags.G41=vect.Flags.G41;
temp.Flags.G42=vect.Flags.G42;
temp.Flags.CreatedFlag=vect.Flags.CreatedFlag;
temp.Flags.KerfFlag=vect.Flags.KerfFlag;
temp.Flags.LeadInFlag=vect.Flags.LeadInFlag;
temp.Flags.LeadOutFlag=vect.Flags.LeadOutFlag;
temp.Flags.MarkingCut=vect.Flags.MarkingCut;
temp.Flags.MarkingEnable=vect.Flags.MarkingEnable;
temp.Flags.MiddleSideBevelCutisLegal=vect.Flags.MiddleSideBevelCutisLegal;
temp.Flags.PiercingWith90DegreeCancel=vect.Flags.PiercingWith90DegreeCancel;
temp.Flags.PlasmaCut=vect.Flags.PlasmaCut;
temp.Flags.PlasmaEnable=vect.Flags.PlasmaEnable;
temp.Flags.RapidOn=vect.Flags.RapidOn;
temp.Flags.SkipFlag=vect.Flags.SkipFlag;
temp.Flags.SmallHole=vect.Flags.SmallHole;
temp.Flags.TopSideBevelCutisLegal=vect.Flags.TopSideBevelCutisLegal;

temp.PiercingAngle=vect.PiercingAngle;
temp.BottomSideBevelHeight=vect.BottomSideBevelHeight;
temp.cn2=vect.cn2;


if (Math.abs(temp.oge.xn2 - temp.oge.xn1) > 0.0001 || (Math.abs(temp.oge.yn2 - temp.oge.yn1)) > 0.0001 || (Math.abs(temp.oge.an2 - temp.oge.an1)) > 0.0001)
temp.FeedRate=vect.FeedRate;
else temp.FeedRate=15000;


temp.MiddleSideBevelHeight=vect.MiddleSideBevelHeight;
temp.cn1=vect.cn1;
temp.TopSideBevelAngle=vect.TopSideBevelAngle;
//if(temp.TopSideBevelAngle!=0)temp.Flags.TopSideBevelCutisLegal=true;//vect.Flags.TopSideBevelCutisLegal=true;
//temp.Flags.BottomSideBevelCutisLegal = false;
//temp.Flags.TopSideBevelCutisLegal = false;
temp.Flags.MiddleSideBevelCutisLegal =false;
temp.TopSideBevelHeight=vect.TopSideBevelHeight;*/

return temp;
}    
    
    
    /**
     * Constructor to wrap InputStream for little and big endian data
     * @param refInStream Inputstream to wrap
     */
    public ReadAja(String AjaFileName) throws FileNotFoundException, IOException {
        
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(AjaFileName)));
        
        
        inStream = in;
        //inStream = refInStream;
        dataInStream = new DataInputStream(inStream);
        byteBuffer = new byte[8]; // Largest data type is 64-bits (8 bytes)
        int uzunluk=(int)in.available()/102;
        for(int i=0;i<uzunluk;i++){
            essivect.add(assignto());
        }
        
        
    }
ArrayList<DxfEssi> getVect(){
return essivect;
}
    @Override
    public int available() throws IOException {
        return dataInStream.available();
    }

    @Override
    public final int read(byte refBuffer[], int offset, int readLen) throws IOException {
        return inStream.read(refBuffer, offset, readLen);
    }

    @Override
    public int read() throws IOException {
        return inStream.read();
    }

    @Override
    public final int readUnsignedByte() throws IOException {
        return dataInStream.readUnsignedByte();
    }

    @Deprecated
    @Override
    public final String readLine() throws IOException {
        return dataInStream.readLine();
    }

    @Override
    public final String readUTF() throws IOException {
        return dataInStream.readUTF();
    }

    @Override
    public final void close() throws IOException {
        dataInStream.close();
    }

    @Override
    public final void readFully(byte refBuffer[]) throws IOException {
        dataInStream.readFully(refBuffer, 0, refBuffer.length);
    }

    @Override
    public final void readFully(byte refBuffer[], int offset, int readLen) throws IOException {
        dataInStream.readFully(refBuffer, offset, readLen);
    }

    @Override
    public final int skipBytes(int n) throws IOException {
        return dataInStream.skipBytes(n);
    }

    @Override
    public final boolean readBoolean() throws IOException {
        return dataInStream.readBoolean();
    }

    @Override
    public final byte readByte() throws IOException {
        return dataInStream.readByte();
    }

    @Override
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public final short readShort() throws IOException {
        return dataInStream.readShort();
    }

    @Override
    public final int readUnsignedShort() throws IOException {
        return dataInStream.readUnsignedShort();
    }

    @Override
    public final long readLong() throws IOException {
        return dataInStream.readLong();
    }

    @Override
    public final char readChar() throws IOException {
        return dataInStream.readChar();
    }

    @Override
    public final int readInt() throws IOException {
        return dataInStream.readInt();
    }

    /**
     * Reads floating point type stored in little endian (see readFloat() for big endian)
     * @return float value translated from little endian
     * @throws IOException if an IO error occurs
     */
    public final float readLittleFloat() throws IOException {
        return Float.intBitsToFloat(readLittleInt());
    }    

    /**
     * Reads double precision floating point type stored in little endian (see readDouble() for big endian)
     * @return double precision float value translated from little endian
     * @throws IOException if an IO error occurs
     */    
    public final double readLittleDouble() throws IOException {
        return Double.longBitsToDouble(readLittleLong());
    }

    /**
     * Reads short type stored in little endian (see readShort() for big endian)
     * @return short value translated from little endian
     * @throws IOException if an IO error occurs
     */    
    public final short readLittleShort() throws IOException {
    dataInStream.readFully(byteBuffer, 0, 2);
    return (short)((byteBuffer[1] & 0xff) << 8 | (byteBuffer[0] & 0xff));
    }

    /**
     * Reads char (16-bits) type stored in little endian (see readChar() for big endian)
     * @return char value translated from little endian
     * @throws IOException if an IO error occurs
     */    
    public final char readLittleChar() throws IOException {
        dataInStream.readFully(byteBuffer, 0, 2);
        return (char)((byteBuffer[1] & 0xff) << 8 | (byteBuffer[0] & 0xff));
    }    

    /**
     * Reads integer type stored in little endian (see readInt() for big endian)
     * @return integer value translated from little endian
     * @throws IOException if an IO error occurs
     */        
    public final int readLittleInt() throws IOException {
        dataInStream.readFully(byteBuffer, 0, 4);
        return (byteBuffer[3]) << 24 | (byteBuffer[2] & 0xff) << 16 |
            (byteBuffer[1] & 0xff) << 8 | (byteBuffer[0] & 0xff);
    }
    
    

    /**
     * Reads long type stored in little endian (see readLong() for big endian)
     * @return long value translated from little endian
     * @throws IOException if an IO error occurs
     */        
    public final long readLittleLong() throws IOException {
        dataInStream.readFully(byteBuffer, 0, 8);
        return (long)(byteBuffer[7]) << 56 | (long)(byteBuffer[6]&0xff) << 48 |
            (long)(byteBuffer[5] & 0xff) << 40 | (long)(byteBuffer[4] & 0xff) << 32 |
            (long)(byteBuffer[3] & 0xff) << 24 | (long)(byteBuffer[2] & 0xff) << 16 |
            (long)(byteBuffer[1] & 0xff) <<  8 | (long)(byteBuffer[0] & 0xff);
    }

    /**
     * Reads unsigned short type stored in little endian (see readUnsignedShort() for big endian)
     * @return integer value representing unsigned short value translated from little endian
     * @throws IOException if an IO error occurs
     */        
    public final int readLittleUnsignedShort() throws IOException {
        dataInStream.readFully(byteBuffer, 0, 2);
        return ((byteBuffer[1] & 0xff) << 8 | (byteBuffer[0] & 0xff));
    }
}

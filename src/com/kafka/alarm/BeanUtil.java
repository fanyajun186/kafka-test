package com.kafka.alarm;



import java.io.*;

/**
 * @author xuezhi_xu@hansight.com
 * @date 16/11/1 上午11:16
 */
public  class BeanUtil {

    /**
     * 对象转字节数�?
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] object2Bytes(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException e) {

        }
        return bytes;
    }

    /**
     * 将数组字节转换为对象
     * @param bytes
     * @return
     */
    public static Object ByteToObject(byte[] bytes) {
        Object obj = null;
        try {

            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }
}

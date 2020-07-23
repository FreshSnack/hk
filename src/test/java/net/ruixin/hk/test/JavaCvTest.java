package net.ruixin.hk.test;

/*import org.bytedeco.javacpp.opencv_core;*/
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameFilter;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author mxding
 * @date 2020-05-07 12:34
 */
public class JavaCvTest {

    // http://101.69.216.133:83/openUrl/Lr9bPeU/live.m3u8
    @Test
    public void testCutFrame() throws Exception {
        fetchFrame("http://101.69.216.133:83/openUrl/tK4fVq8/live.m3u8", "F:\\idea\\workspace\\hk\\output\\1.png");
    }


    private void fetchFrame(String videofile, String framefile)
            throws Exception {
        /*long start = System.currentTimeMillis();*/
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        /*ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }*/
        /*ff.setFormat();*/
        ff.start();
        Frame frame = ff.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage image = converter.getBufferedImage(frame);
        ImageIO.write(image, "png", targetFile);
        ff.stop();
        /*opencv_core.IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();*/
        // 对截取的帧进行等比例缩放
        /*int width = 800;
        //int height = (int) (((double) width / owidth) * oheight);
        int height = 600;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(image,
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);*/
    }


    @Test
    public void testFrame() throws Exception {
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(new File(System.getProperty("user.dir") + "/test.h264"));

        frameGrabber.setFrameRate(100);
        frameGrabber.setFormat("h264");
        frameGrabber.setVideoBitrate(15);
        frameGrabber.setVideoOption("preset", "ultrafast");
        frameGrabber.setNumBuffers(25000000);

        Java2DFrameConverter converter = new Java2DFrameConverter();

        frameGrabber.start();

        Frame frame = frameGrabber.grab();
        BufferedImage bufferedImage = converter.convert(frame);
        File file = new File(System.getProperty("user.dir") + "/temp/image_" + 1 + ".jpg");
        ImageIO.write(bufferedImage, "jpg", file);
        /*baos.flush();
        baos.close();*/
    }

    @Test
    public void testGrap() {

    }
}

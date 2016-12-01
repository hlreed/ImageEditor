import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Hope on 11/28/2016.
 */
public class Editor {
    int [][] pixels;
    protected String magic;
    protected int width;
    protected int height;
    protected int depth;

    public Editor () {
        magic = "";
        width = 0;
        height = 0;
        depth = 0;
        pixels = new int [1][1];
        pixels[0][0] = 0;
    }



    public int[][] getPixels() {
        return pixels;
    }

    public String getMagic() {
        return magic;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public Editor(String userfile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(userfile));
        magic = sc.next();
        width = sc.nextInt();
        height = sc.nextInt();
        depth = sc.nextInt();
        pixels = new int [height][width * 3];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width * 3; j++) {
                pixels [i][j] = sc.nextInt();
            }
        }
    }

    public void negate_red() {
            int[][] pixelsNRed = new int [height][width * 3];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width * 3; j++) {
                    int pix = depth - pixels[i][j];
                    pixelsNRed[i][j] = pix;
                    pixelsNRed[i][j + 1] = pixels[i][j + 1];
                    pixelsNRed[i][j + 2] = pixels[i][j + 2];
                    j += 2;
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width * 3; j++) {
                    pixels[i][j] = pixelsNRed[i][j];
                }
            }
        }

    public void negate_green() {
        int[][] pixelsNGreen = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                int pix = depth - pixels[i][j + 1];
                pixelsNGreen[i][j] = pixels[i][j];
                pixelsNGreen[i][j + 1] = pix;
                pixelsNGreen[i][j + 2] = pixels[i][j + 2];
                j =+2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsNGreen[i][j];
            }
        }
    }

    public void negate_blue() {
        int[][] pixelsNBlue = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                int pix = depth - pixels[i][j + 2];
                pixelsNBlue[i][j] = pixels[i][j];
                pixelsNBlue[i][j + 1] = pixels[i][j + 1];
                pixelsNBlue[i][j + 2] = pix;
                j += 2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsNBlue[i][j];
            }
        }
    }

    public void flatten_red() {
        int[][] pixelsF = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixelsF[i][j] = 0;
                pixelsF[i][j + 1] = pixels[i][j + 1];
                pixelsF[i][j + 2] = pixels[i][j + 2];
                j += 2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsF[i][j];
            }
        }
    }

    public void flatten_green() {
        int[][] pixelsF = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixelsF[i][j] = pixels[i][j];
                pixelsF[i][j + 1] = 0;
                pixelsF[i][j + 2] = pixels[i][j + 2];
                j += 2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsF[i][j];
            }
        }
    }

    public void grey_scale() {
        int[][] pixelsG = new int [height][width * 3];
        int total;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                total = 0;
                total += pixels[i][j];
                total += pixels[i][j + 1];
                total += pixels[i][j + 2];
                total = total/3;
                pixelsG[i][j] = total;
                pixelsG[i][j + 1] = total;
                pixelsG[i][j + 2] = total;
                j += 2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsG[i][j];
            }
        }
    }

    public void flatten_blue() {
        int[][] pixelsF = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixelsF[i][j] = pixels[i][j];
                pixelsF[i][j + 1] = pixels[i][j + 1];
                pixelsF[i][j + 2] = 0;
                j += 2;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsF[i][j];
            }
        }
    }

    public void extreme_contrast() {
        int[][] pixelsE = new int [height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                int pix = pixels[i][j];
                if(pix < depth/2) {
                    pix = 0;
                }
                else{
                    pix = depth;
                }
                pixelsE[i][j] = pix;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                pixels[i][j] = pixelsE[i][j];
            }
        }
    }

        public void flip_horizontally () {
            int[][] pixelsHor = new int[height][width * 3];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width * 3; j++) {
                    pixelsHor[i][j] = pixels[i][(width * 3) - 3 - j];
                    pixelsHor[i][j+1] = pixels[i][(width*3) - 2 - j];
                    pixelsHor[i][j + 2] = pixels[i][(width * 3) - 1 - j];
                    j += 2;
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width * 3; j++) {
                    pixels[i][j] = pixelsHor[i][j];
                }
            }

        }

}

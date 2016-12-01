import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Hope on 11/28/2016.
 */
public class ImageEditor extends Editor {
    public void main(String[] args) {

            Scanner sca = new Scanner(System.in);
            System.out.print("Portable Pixmap (PPM) Image Editor\n\n");
            System.out.print("Enter name of image file: ");
            String userfile = sca.next();
            try
            {
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
                System.out.print("\nEnter the name of output file");
                String outputFile = sca.next();
                System.out.print("\nHere are your choices:\n[1]  convert to greyscale [2]  flip horizontally\n" +
                        "[3]  negative of red [4]  negative of green [5]  negative of blue\n" +
                        "[6]  just the reds   [7]  just the greens   [8]  just the blues\n" + "[10] extreme contrast\n");

                System.out.print("\nDo you want [1]? (y/n) ");
                String opt1 = sca.next();
                System.out.print("\nDo you want [2]? (y/n) ");
                String opt2 = sca.next();
                System.out.print("\nDo you want [3]? (y/n) ");
                String opt3 = sca.next();
                System.out.print("\nDo you want [4]? (y/n) ");
                String opt4 = sca.next();
                System.out.print("\nDo you want [5]? (y/n) ");
                String opt5 = sca.next();
                System.out.print("\nDo you want [6]? (y/n) ");
                String opt6 = sca.next();
                System.out.print("\nDo you want [7]? (y/n) ");
                String opt7 = sca.next();
                System.out.print("\nDo you want [8]? (y/n) ");
                String opt8 = sca.next();

                if (opt1.equals("y")) {
                    grey_scale();
                }
                if(opt2.equals("y")) {
                    flip_horizontally();
                }
                if(opt3.equals("y")) {
                    negate_red();
                }
                if(opt4.equals("y")) {
                    negate_green();
                }
                if(opt5.equals("y")) {
                    negate_blue();
                }
                if(opt6.equals("y")) {
                    flatten_red();
                }
                if(opt7.equals("y")) {
                    flatten_green();
                }
                if(opt8.equals("y")) {
                    flatten_blue();
                }

                PrintWriter writer = new PrintWriter(outputFile);
                writer.println(magic + "\n" + width + " " + height + " " + depth);
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width * 3; j++) {
                        writer.print(pixels[i][j] + " ");
                    }
                }
                writer.close();
            }
            catch (FileNotFoundException ex) {
                System.out.println("Error");
            }


        }
    }

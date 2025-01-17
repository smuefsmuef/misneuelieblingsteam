package ip12.ws2cQlockTwo;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.IntList;

/**
 * QLOCKTWO in Processing
 * Credits for original design and all rights belong to: https://qlocktwo.com
 * This Processing Sketch Author: Michael Job
 * Version: 0.1 - Startercode for ws2C
 * Wordlist de:
 *  ES K IST A FÜNF
 *  ZEHN BYG VOR G
 *  NACH VIERTEL
 *  HALB VOR NACH
 *  EIN-S LME ZWEI
 *  DREI AUJ VIER
 *  FÜNF TO SECHS
 *  SIEBEN L ACHT
 *  NEUN ZEHN ELF
 *  ZWÖLF UNK UHR
 **/
public class QlockTwoStarterApp extends PApplet {
    int xWidth, yHeight;
    int black = color(0, 0, 0);
    int grey = color(50, 50, 50);
    int white = color(255, 255, 255);
    int random = color(123, 34, 77);  //bordeux/violett
    PFont dinFont;
    int margin = 30;

    char[] de = {
            'E', 'S', 'K', 'I', 'S', 'T', 'A', 'F', 'Ü', 'N', 'F', //10
            'Z', 'E', 'H', 'N', 'B', 'Y', 'G', 'V', 'O', 'R', 'G', //21
            'N', 'A', 'C', 'H', 'V', 'I', 'E', 'R', 'T', 'E', 'L', //32
            'H', 'A', 'L', 'B', 'V', 'O', 'R', 'N', 'A', 'C', 'H', //43
            'E', 'I', 'N', 'S', 'L', 'M', 'E', 'Z', 'W', 'E', 'I', //54
            'D', 'R', 'E', 'I', 'A', 'U', 'J', 'V', 'I', 'E', 'R', //65
            'F', 'Ü', 'N', 'F', 'T', 'O', 'S', 'E', 'C', 'H', 'S', //76
            'S', 'I', 'E', 'B', 'E', 'N', 'L', 'A', 'C', 'H', 'T', //87
            'N', 'E', 'U', 'N', 'Z', 'E', 'H', 'N', 'E', 'L', 'F', //98
            'Z', 'W', 'Ö', 'L', 'F', 'U', 'N', 'K', 'U', 'H', 'R' //109
    };

    public static void main(String[] args) {
        PApplet.main(new String[]{QlockTwoStarterApp.class.getName()});
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        dinFont = createFont("DIN-Pro.ttf", 40);
        textFont(dinFont);
        textAlign(CENTER);
        xWidth = 800;
        yHeight = 800;
    }


    public void draw() {
        background(random);
        //get time
        int m = minute();  // Values from 0 - 59
        int h = hour() % 12;    // Values from 0-11

        //TODO showCase Demomode

        IntList onIndicies = getOnIndicies(h, m);
        //draw Letters
        int y = (int) (4.5 * margin);
        for (int i = 0; i < de.length; i++) {
            if (i % 11 == 0) {
                y += 50;
            }
            if (onIndicies.hasValue(i)) {
                fill(white);
            } else {
                fill(grey);
            }
            text(de[i], 5 * margin + 50 * (i % 11), y);
        }

        //TODO: draw dots for minutes 1,2,3,4,-,6,7,8,9

    }

    IntList getOnIndicies(int h, int m) {
        int m5 = m - m % 5; //round to lower 5 min.
        //over and on 20 min. past h show next hour value
        if (m5 >= 20) h += 1;
        if (h == 12) h = 0;

        IntList onIdx = new IntList();
        //ES IST
        onIdx.append(0);
        onIdx.append(1);
        onIdx.append(3);
        onIdx.append(4);
        onIdx.append(5);

        switch (h) {
            case 0:
                //0:00 == Zwölf Uhr
                onIdx.append(99);
                onIdx.append(100);
                onIdx.append(101);
                onIdx.append(102);
                onIdx.append(103);
                break;
            case 1:
                onIdx.append(44);
                onIdx.append(45);
                onIdx.append(46);
                if (m5 != 0) {
                    onIdx.append(47);
                }
                break;
            case 2:
                onIdx.append(51);
                onIdx.append(52);
                onIdx.append(53);
                onIdx.append(54);
                break;
            case 3:
                onIdx.append(55);
                onIdx.append(56);
                onIdx.append(57);
                onIdx.append(58);
                break;
            case 4:
                onIdx.append(62);
                onIdx.append(63);
                onIdx.append(64);
                onIdx.append(65);
                break;
            case 5:
                set5(onIdx);
                break;
            case 6:
                onIdx.append(72);
                onIdx.append(73);
                onIdx.append(74);
                onIdx.append(75);
                onIdx.append(76);
                break;
            case 7:
                onIdx.append(77);
                onIdx.append(78);
                onIdx.append(79);
                onIdx.append(80);
                onIdx.append(81);
                onIdx.append(82);
                break;
            case 8:
                onIdx.append(84);
                onIdx.append(85);
                onIdx.append(86);
                onIdx.append(87);
                break;
            case 9:
                onIdx.append(88);
                onIdx.append(89);
                onIdx.append(90);
                onIdx.append(91);
                break;
            case 10:
                set10(onIdx);
                break;
            case 11:
                onIdx.append(96);
                onIdx.append(97);
                onIdx.append(98);
                break;
        }

        switch (m5) {
            case 0:
                //UHR
                onIdx.append(107);
                onIdx.append(108);
                onIdx.append(109);
                break;
            case 5:
                setNACH(onIdx);
                set5MIN(onIdx);
                break;
            case 10:
                setNACH(onIdx);
                set10MIN(onIdx);
                break;
            case 15:
                setVIERTELNACH(onIdx);
                break;
            case 20:
                setVOR(onIdx);
                set10MIN(onIdx);
                setHALB(onIdx);
                break;
            case 25:
                set5MIN(onIdx);
                setVOR(onIdx);
                setHALB(onIdx);
                break;
            case 30:
                setHALB(onIdx);
                break;
            case 35:
                set5MIN(onIdx);
                setNACH(onIdx);
                setHALB(onIdx);
                break;
            case 40:
                setNACH(onIdx);
                set10MIN(onIdx);
                setHALB(onIdx);
                break;
            case 45:
                setVIERTELVOR(onIdx);
                break;
            case 50:
                setVOR(onIdx);
                set10MIN(onIdx);
                break;
            case 55:
                set5MIN(onIdx);
                setVOR(onIdx);
                break;
        }

        return onIdx;
    }

    void set5(IntList onIdx) {
        onIdx.append(66);
        onIdx.append(67);
        onIdx.append(68);
        onIdx.append(69);
    }

    void set10(IntList onIdx) {
        onIdx.append(92);
        onIdx.append(93);
        onIdx.append(94);
        onIdx.append(95);
    }

    void set5MIN(IntList onIdx) {
        onIdx.append(7);
        onIdx.append(8);
        onIdx.append(9);
        onIdx.append(10);
    }

    void set10MIN(IntList onIdx) {
        onIdx.append(11);
        onIdx.append(12);
        onIdx.append(13);
        onIdx.append(14);
    }

    void setVOR(IntList onIdx) {
        onIdx.append(18);
        onIdx.append(19);
        onIdx.append(20);
    }

    void setVIERTELVOR(IntList onIdx) {
        setVIERTEL(onIdx);
        onIdx.append(37);
        onIdx.append(38);
        onIdx.append(39);
    }

    void setNACH(IntList onIdx) {
        onIdx.append(22);
        onIdx.append(23);
        onIdx.append(24);
        onIdx.append(25);
    }

    void setVIERTELNACH(IntList onIdx) {
        setVIERTEL(onIdx);
        onIdx.append(40);
        onIdx.append(41);
        onIdx.append(42);
        onIdx.append(43);
    }

    void setHALB(IntList onIdx) {
        onIdx.append(33);
        onIdx.append(34);
        onIdx.append(35);
        onIdx.append(36);
    }

    void setVIERTEL(IntList onIdx) {
        onIdx.append(26);
        onIdx.append(27);
        onIdx.append(28);
        onIdx.append(29);
        onIdx.append(30);
        onIdx.append(31);
        onIdx.append(32);
    }

    //TODO: key controls

            //TODO: set demo show mode if "s" is pressed

            //TODO: set black backgroundcolor if key "b" is pressed

            //TODO: set random backgroundcolor if key "c" is pressed

            //TODO: language settings

}
package MP3;

import java.util.*;

public class main {
    public static void main(String[] args) {
        HRS hrs = new HRS();
      
        hrs.promptHotelSystem();

        switch(choice)
        {
            case 1:
                hrs.promptCreateHotel();
                break;
            case 2:
                hrs.promptViewHotel();
                break;
            case 3:
                hrs.promptManageHotel();
                break;
            case 4:
                hrs.promptSimulateBooking();
                break;
        }
    }
}
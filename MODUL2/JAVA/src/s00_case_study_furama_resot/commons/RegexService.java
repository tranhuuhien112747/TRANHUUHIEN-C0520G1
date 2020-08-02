package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.House;
import s00_case_study_furama_resot.models.Room;
import s00_case_study_furama_resot.models.Villa;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexService {
    /**
     * Service codes must be in the correct format: SVXX-YYYY, with YYYY numbers from 0-9, XX are:
     * -	If it is Villa then XX will be VL
     * -	If it is House then XX will be HO
     * -	If it is Room then XX will be RO
     * ----------------------CHECK ID SERVICES--------------------------------
     */
    public static String checkIdVila(String id) {
        final String VILLA_ID_REGEX = "^((SVVL-)\\d{4})$";
        Pattern pattern = Pattern.compile(VILLA_ID_REGEX);
        Matcher matcher = pattern.matcher(id);
        Scanner input = new Scanner(System.in);
        boolean check = false;
        for (int i = 0; i < Villa.getVillaList().size(); i++) {
            if (id.equals(Villa.getVillaList().get(i).getId())) {
                System.err.println("ID services already in the list. Please enter");
                check = true;
                break;
            }
        }
        while (check || !matcher.matches()) {
            System.err.println("Villa service's ID must be SVVL-XXXX (XXXX includes any numbers from 0 to 9. Enter again:)");
            id = input.nextLine();
            matcher = pattern.matcher(id);
            for (int i = 0; i < Villa.getVillaList().size(); i++) {
                if (id.equals(Villa.getVillaList().get(i).getId())) {
                    System.err.println("ID services already in the list. Please enter");
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return id;
    }

    public static String checkIdHouse(String id) {
        final String HOUSE_ID_REGEX = "^((SVHO-)\\d{4})$";
        Pattern pattern = Pattern.compile(HOUSE_ID_REGEX);
        Matcher matcher = pattern.matcher(id);
        Scanner input = new Scanner(System.in);
        boolean check = false;
        for (int i = 0; i < House.getHouseList().size(); i++) {
            if (id.equals(House.getHouseList().get(i).getId())) {
                System.err.println("ID services already in the list. Please enter");
                check = true;
                break;
            }
        }
        while (check || !matcher.matches()) {
            System.err.println("Villa service's ID must be SVVL-XXXX (XXXX includes any numbers from 0 to 9. Enter again:)");
            id = input.nextLine();
            matcher = pattern.matcher(id);
            for (int i = 0; i < House.getHouseList().size(); i++) {
                if (id.equals(House.getHouseList().get(i).getId())) {
                    System.err.println("ID services already in the list. Please enter");
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return id;
    }

    public static String checkIdRoom(String id) {
        final String ROOM_ID_REGEX = "^((SVRO-)\\d{4})$";
        Pattern pattern = Pattern.compile(ROOM_ID_REGEX);
        Matcher matcher = pattern.matcher(id);
        Scanner input = new Scanner(System.in);
        boolean check = false;
        for (int i = 0; i < Room.getRoomList().size(); i++) {
            if (id.equals(Room.getRoomList().get(i).getId())) {
                System.err.println("ID services already in the list. Please enter");
                check = true;
                break;
            }
        }
        while (check || !matcher.matches()) {
            System.err.println("Villa service's ID must be SVVL-XXXX (XXXX includes any numbers from 0 to 9. Enter again:)");
            id = input.nextLine();
            matcher = pattern.matcher(id);
            for (int i = 0; i < Room.getRoomList().size(); i++) {
                if (id.equals(Room.getRoomList().get(i).getId())) {
                    System.err.println("ID services already in the list. Please enter");
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return id;
    }

    /**
     * The service name must be capitalized with first letters, the following characters shall be normal characters.
     * Rent type, Standard room for standardizing data like the service name.
     * Shared for Name Service, Standard Room, Type of Rent.
     * ---------------------------------CHECK NAME FORMAT---------------------------------
     **/

    public static String checkFormat(String nameService) {
        final String NAME_SERVICE_REGEX = "^[A-Z][a-z]{0,9}(([ ][A-Z][a-z]{0,9})*)$";
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile(NAME_SERVICE_REGEX);
        Matcher matcher = pattern.matcher(nameService);
        while (!matcher.matches()) {
            System.err.println("Service name must not contain numbers and must be capitalized in first letter. Enter again:");
            nameService = input.nextLine();
            matcher = pattern.matcher(nameService);

        }
        return nameService;

    }

    /**
     * Use area and pool area must be a real number greater than 30m2.
     * Shared for use area and pool area.
     * ---------------------------------CHECK AREA ---------------------------------------
     */
    public static Double checkArea(String area) {
        final String AREA_REGEX = "^([3][1-9]{1,9}|[4-9]\\d{1,9})([.]?)\\d{0,3}$";
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(AREA_REGEX);
        Matcher matcher = pattern.matcher(area);
        while (!matcher.matches()) {
            System.err.println("The used area must be numeric and larger than 30 m2.Enter  again:");
            area = scanner.nextLine();
            matcher = pattern.matcher(area);
        }
        return Double.parseDouble(area);
    }

    /**
     * The rental cost must be a non-negative number.
     * -------------------------------CHECK RENTAL COSTS---------------------------------------
     */
    public static Double checkRentalCost(String rentalCosts) {
        final String COSTS_REGEX = "^(\\d{1,9})([.]?)\\d{0,3}$";
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(COSTS_REGEX);
        Matcher matcher = pattern.matcher(rentalCosts);
        while (!matcher.matches()) {
            System.err.println("Rent costs must be a number and > 0. Enter again:");
            rentalCosts = scanner.nextLine();
            matcher = pattern.matcher(rentalCosts);
        }
        return Double.parseDouble(rentalCosts);
    }

    /**
     * The maximum number of people must be > 0 and smaller than < 20.
     */
    public static Integer checkMaxPeople(String number) {
        final String MAX_PEOPLE_REGEX = "^([1]\\d?|[2-9])$";
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(MAX_PEOPLE_REGEX);
        Matcher matcher = pattern.matcher(number);
        while (!matcher.matches()) {
            System.err.println("Maximum number of people must be number and > 0 and smaller than < 20. Enter again:");
            number = scanner.nextLine();
            matcher = pattern.matcher(number);
        }
        return Integer.parseInt(number);
    }

    /**
     * Number of floors must be non-negative.
     */
    public static Integer checkFloor(String number) {
        final String FLOOR_REGEX = "^\\d{1,9}$";
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(FLOOR_REGEX);
        Matcher matcher = pattern.matcher(number);
        while (!matcher.matches()) {
            System.err.println("The number of floors must be a number and not negative. Enter again:");
            number = scanner.nextLine();
            matcher = pattern.matcher(number);
        }
        return Integer.parseInt(number);
    }

}

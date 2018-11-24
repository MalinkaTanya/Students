package by.itacademy.menu;

public abstract class СheckTheMenuNumber {

    public int checkInputValue(String choice) throws ChoiceExecutionException {
        try {
            int intChoice = Integer.parseInt(choice);
            return intChoice;
        } catch (NumberFormatException e) {
            throw new ChoiceExecutionException("Invalid value entered!");
        }
    }
}

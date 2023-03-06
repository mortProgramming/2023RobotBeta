package frc.robot.util;

public class Logic {

    public static boolean pressedLogic(boolean newInput, boolean oldInput){
        if(newInput == true && oldInput == false){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean unPressedLogic(boolean newInput, boolean oldInput){
        if(newInput == false && oldInput == true){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean pressed2ToggleLogic(boolean pressed, boolean oldAlternate){
        if(pressed == true){
            if(oldAlternate == true){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return oldAlternate;
        }
    }

    public static int pressedMultiToggleLogic(boolean pressed, int oldAlternate, int numPressed){
        if(pressed == true){
            if(oldAlternate < numPressed){
                return (oldAlternate + 1);
            }
            else{
                return 1;
            }
        }
        else{
            return oldAlternate;
        }
    }

    public static boolean lessGreater(double begin, double current, double end){
       if(current > begin && current < end){
        return true;
       }
       else{
        return false;
       }
    }

    public static int plusNeg(double input){
        if(input < 0){
            return -1;
        }
        else if(input == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static double deadband(double value, double deadband) {

		if (Math.abs(value) > deadband) {

			if (value > 0.0) {
				return (value - deadband) / (1.0 - deadband);
			} 
            else {
				return (value + deadband) / (1.0 - deadband);
			}
		} 
        
        else {
			return 0.0;
		}
	}

    private static double modifyAxis(double value, double throttleValue) {
		value = deadband(value, 0.1);

		throttleValue = (throttleValue + 1) / 2;

		double minValue = 0;
		double maxValue = 1;
		return value * (throttleValue * (maxValue - minValue) + minValue);
	}

    public static double modifySquareAxis(double value, double throttleValue) {
		value = deadband(value, 0.1);

		// Square the axis
		value = Math.copySign(value * value, value);

		throttleValue = (throttleValue + 1) / 2;

		double minValue = 0;
		double maxValue = 1;
		return value * (throttleValue * (maxValue - minValue) + minValue);
	}
}

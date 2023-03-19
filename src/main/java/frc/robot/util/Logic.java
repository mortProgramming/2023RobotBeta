package frc.robot.util;

import static frc.robot.util.Constants.*;

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

    public static double modifyAxis(double value, double throttleValue) {
		value = deadband(value, DEAD_BAND);

		throttleValue = (throttleValue + 1) / 2;

		return value * (throttleValue * (MAX_THROTTLE - MIN_THROTTLE) + MIN_THROTTLE);
	}

    public static double modifySquareAxis(double value, double throttleValue) {
		value = deadband(value, DEAD_BAND);

		// Square the axis
		value = Math.copySign(value * value, value);

		throttleValue = (throttleValue + 1) / 2;

		return value * (throttleValue * (MAX_THROTTLE - MIN_THROTTLE) + MIN_THROTTLE);
	}

    public static double modifyCubicAxis(double value, double throttleValue) {
		value = deadband(value, DEAD_BAND);

		value = Math.copySign(value * value * value, value);

		throttleValue = (throttleValue + 1) / 2;

		return value * (throttleValue * (MAX_THROTTLE - MIN_THROTTLE) + MIN_THROTTLE);
	}

    public static double armStabalize(double encoderValue) {
        return Math.sin(Math.toRadians(armMotorPositionToDegrees(encoderValue)));
    }

    // public static double armMotorPositionToDegrees(double encoderValue) {
    //     return (encoderValue - ARM_MOTOR_ENCODER_MIN) / ARM_POSITION_TO_DEGREES + ARM_MOTOR_ENCODER_TO_0_DEGREES;
    // }

    // public static double armMotorDegreesToPosition(double degrees) {
    //     return ((degrees - ARM_MOTOR_ENCODER_TO_0_DEGREES) * ARM_POSITION_TO_DEGREES) + ARM_MOTOR_ENCODER_MIN;
    // }

    public static double armMotorPositionToDegrees(double encoderValue) {
        return (encoderValue + ARM_MOTOR_ENCODER_TO_0_DEGREES) / ARM_POSITION_TO_DEGREES;
    }

    public static double armMotorDegreesToPosition(double degrees) {
        return (degrees * ARM_POSITION_TO_DEGREES) - ARM_MOTOR_ENCODER_TO_0_DEGREES;
    }

    public static double scale(double scalingValue, double constant) {
        if(constant > 0) {
            return scalingValue * (1 - constant) + constant; 
        }
        else {
            return scalingValue * (1 + constant) - constant; 
        }
    }
}

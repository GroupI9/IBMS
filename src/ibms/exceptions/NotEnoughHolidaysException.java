/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.exceptions;

/**
 *
 * @author nunnerp0
 */
public class NotEnoughHolidaysException extends Exception {

    /**
     * Creates a new instance of <code>NotEnoughHolidaysException</code> without detail message.
     */
    public NotEnoughHolidaysException() {
    }


    /**
     * Constructs an instance of <code>NotEnoughHolidaysException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NotEnoughHolidaysException(String msg) {
        super(msg);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.exceptions;

/**
 *
 * @author nunnerp0
 */
public class DateTakenException extends Exception {

    /**
     * Creates a new instance of <code>DateTakenException</code> without detail message.
     */
    public DateTakenException() {
    }


    /**
     * Constructs an instance of <code>DateTakenException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DateTakenException(String msg) {
        super(msg);
    }
}

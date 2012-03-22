/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.exceptions;

/**
 *
 * @author nunnerp0
 */
public class UnknownDriverException extends Exception {

    /**
     * Creates a new instance of <code>UnknownDriverException</code> without detail message.
     */
    public UnknownDriverException() {
    }


    /**
     * Constructs an instance of <code>UnknownDriverException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public UnknownDriverException(String msg) {
        super(msg);
    }
}

/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.exceptions;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }

    public UnauthorizedAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

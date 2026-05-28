package views.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class GlobalExceptionHandler {

    private static final Validator validator;

    // Inisialisasi engine Jakarta Validation dari JAR secara otomatis saat aplikasi berjalan
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Menggantikan peran ControllerAdvice. 
     * Fungsi ini menerima objek input apa saja (DTO), memvalidasinya, 
     * dan mengembalikan Map berisi daftar error.
     *
     * @param request Objek DTO yang ingin divalidasi (misal: LoginRequest)
     * @return Map berisi nama field yang error beserta pesannya. Jika kosong, berarti input valid.
     */
    public static Map<String, String> handleValidation(Object request) {
        Map<String, String> errors = new HashMap<>();

        // Jalankan validasi menggunakan engine Jakarta
        Set<ConstraintViolation<Object>> violations = validator.validate(request);

        // Ambil semua field yang error dan kumpulkan pesannya (mirip alur getFieldErrors di Spring)
        for (ConstraintViolation<Object> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            
            errors.put(fieldName, errorMessage);
        }

        // Kembalikan daftar error (jika Map kosong, berarti data 100% aman)
        return errors;
    }
}

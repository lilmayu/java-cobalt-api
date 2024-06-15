package dev.mayuna.cobalt.api.objects;

import lombok.Getter;

/**
 * Represents the picker type.
 */
@Getter
public final class PickerType {

    public static final PickerType VARIOUS = new PickerType("various");
    public static final PickerType IMAGES = new PickerType("images");

    private String pickerType;

    /**
     * Used for deserialization.
     */
    public PickerType() {
    }

    /**
     * Creates a new picker type.
     *
     * @param pickerType The picker type.
     */
    private PickerType(String pickerType) {
        this.pickerType = pickerType;
    }

    /**
     * Creates {@link PickerType} from a string.
     *
     * @param pickerType The picker type.
     *
     * @return Created {@link PickerType} instance.
     */
    public static PickerType fromString(String pickerType) {
        switch (pickerType) {
            case "various":
                return VARIOUS;
            case "images":
                return IMAGES;
            default:
                return new PickerType(pickerType);
        }
    }
}

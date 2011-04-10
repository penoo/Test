/**
 * The Vector2d class describes a non-positional 2-dimensional vector.
 * @author penoo
 * @version 
 */
public class Vector2d {
    /** The components of this vector. */
    private float mX1, mX2;
	
    /** The length of this vector. */
    private float mLength;
	
	
    //CONSTRUCTORS
	
    /**
     * Create the zero vector.
     */
    public Vector2d() {
        this(0f, 0f);
    }
	
    /**
     * Create a copy of the given vector.
     */
    public Vector2d(Vector2d v) {
        this(v.x1(), v.x2());
    }
	
    /**
     * Create a new instance of Vector2d with the given components.
     */
    public Vector2d(float x1, float x2) {
        mX1 = x1;
        mX2 = x2;
        calculateLength();
    }
	
	
    //ACCESSORS
	
    /**
     * Perform an addition of this vector with the given vector v.
     * Does not modify this Vector2d. 
     * @return The vector resulting from an addition between this vector and v.
     */
    public Vector2d add(Vector2d v) {
        return new Vector2d(mX1 + v.mX1, mX2 + v.mX2);
    }
	
    /**
     * Perform a subtraction of the given vector v on this vector.
     * Does not modify this vector.
     * @return The vector resulting from a subtraction between this vector 
     * and v.
     */
    public Vector2d subtract(Vector2d v) {
        return new Vector2d(mX1 - v.mX1, mX2 - v.mX2);
    }
	
    /**
     * Get the dot-product of this vector and the given vector v.
     * Does not modify this vector.
     * @return The dot-product of this vector and the given vector v.
     */
    public float dot(Vector2d v) {
        return mX1 * v.mX1 + mX2 * v.mX2;
    }
	
    /**
     * Multiply this vector with a scalar. 
     * Does not modify this vector.
     * @return A vector with the same direction as this vector, scaled
     * with the factor <code>scalar</code>.
     */
    public Vector2d scale(float scalar) {
        return new Vector2d(mX1 * scalar, mX2 * scalar);
    }
	
    /**
     * Get a normalized copy of this vector.
     * Does not modify this vector.
     * @return A normalized copy of this vector. <code>null</code> if 
     * length <= 0.
     */
    public Vector2d getNormalizedCopy() {
        if (mLength > 0) {
            Vector2d tempVector = this;
            return tempVector.scale(1f / tempVector.length());
        }
        return null;
    }
	
    /**
     * Get the first element of this vector.
     */
    public float x1() {return mX1;}
	
    /**
     * Get the second element of this vector.
     */
    public float x2() {return mX2;}
	
    /**
     * Get the length of this vector.
     */
    public float length() {return mLength;}
	
	
    //MUTATORS
	
    /**
     * Calculate the length of this vector.
     */
    private void calculateLength() {
        Vector2d tempVector = this;
        float scalarProd = tempVector.dot(tempVector);
        mLength = (float)Math.sqrt(scalarProd);
    }
	
    /** 
     * Normalize this vector.
     * @return <code>true</code> if the operation can be performed (length > 0). 
     * <code>false</code> if the operation can't be performed.
     */
    public boolean normalize() {
        Vector2d normalizedCopy = getNormalizedCopy();
        if (normalizedCopy == null) {
            mX1 = normalizedCopy.x1();
            mX2 = normalizedCopy.x2();
            mLength = normalizedCopy.length(); // will always be 1.
            return true;
        }
        return false;
    }
	
    /**
     * Set the first component of this vector.
     */
    public void setX1(float x1) {
        mX1 = x1;
        calculateLength();
    }
	
    /**
     * Set the second component of this vector.
     */
    public void setX2(float x2) {
        mX2 = x2;
        calculateLength();
    }
	
    /**
     * Set both components of this vector.
     */
    public void set(float x1, float x2) {
        mX1 = x1;
        mX2 = x2;
        calculateLength();
    }
	
    /**
     * Rotate this vector counterclockwise with the given angle.
     * To rotate clockwise, provide a negative angle.
     */
    public void rotate(float radians) {
        float initX1 = mX1;
        mX1 = mX1 * Math.cos(radians) - mX2 * Math.sin(radians);
        mX2 = mX2 * Math.cos(radians) + initX1 * Math.sin(radians);
        calculateLength();
    }
	
    /**
     * Assign a new magnitude to this Vector2d. The direction of this 
     * Vector2d will [almost] not be modified.
     */
    public void setMagnitude(float m) {
        normalize();
        scale(m);
    }
	
    /**
     * Get a String representation of this Vector2d.
     */
    @Override
    public String toString() {
        return "(" + mX1 + ", " + mX2 + ")";
    }
}
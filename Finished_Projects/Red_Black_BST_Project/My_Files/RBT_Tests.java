
import org.junit.Test;

import My_Files.WordTracker;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;


public class RBT_Tests {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

        /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void flipColors() {
        RBT tree = new RBT();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30); 

        assertEquals(Node.Color.BLACK, tree.root.getColor());
        assertEquals(Node.Color.RED, tree.root.getLeft().getColor());
        assertEquals(Node.Color.RED, tree.root.getRight().getColor());
        
        tree.flipColors(tree.root);
        
        assertEquals(Node.Color.RED, tree.root.getColor());
        assertEquals(Node.Color.BLACK, tree.root.getLeft().getColor());
        assertEquals(Node.Color.BLACK, tree.root.getRight().getColor());
    }


}

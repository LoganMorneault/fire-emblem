package View;

import java.io.IOException;

public interface IView {

    /**
     * Renders a model in some way (text, graphics, etc.).
     * @throws IOException if rendering fails.
     */
    void render() throws IOException;
    
}

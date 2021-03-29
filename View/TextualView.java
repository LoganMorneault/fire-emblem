package View;

import java.io.IOException;
import java.util.Objects;

import Model.IModel;


/**
 * Class representing a textual view for the game.
 */
public class TextualView implements IView {
    IModel model;
    Appendable sb;

    /**
     * Constructor for TextualView.
     * @param model the model to be rendered.
     * @param sb the end location of the render.
     */
    public TextualView(IModel model, Appendable sb) {
        this.model = Objects.requireNonNull(model);
        this.sb = Objects.requireNonNull(sb);
    }

    /**
     * Constructor for TextualView.
     * @param model the model to be rendered.
     */
    public TextualView(IModel model) {
        this.model = Objects.requireNonNull(model);
        this.sb = new StringBuilder();
    }


    @Override
    public void render() throws IOException {
        // TODO Auto-generated method stub
        
    }
    
}

package cocostudio.ui.parser.group;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCPanel extends GroupParser {

	@Override
	public String getClassName() {
		return "Panel";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {
		Table table = new Table();
		if (option.getBackGroundImageData() != null) {// Panel的图片并不是拉伸平铺的!!
			// table.setBackground(findDrawable(option, option
			// .getBackGroundImageData().getPath()));
			Drawable drawable = editor.findDrawable(option, option
					.getBackGroundImageData().getPath());
			if (drawable != null) {
				Image bg = new Image(drawable);
				bg.setPosition((option.getWidth() - bg.getWidth()) / 2,
						(option.getHeight() - bg.getHeight()) / 2);
				table.addActor(bg);
			}else {
				
			}
		}

		table.setClip(option.isClipAble());

		return table;
	}

}

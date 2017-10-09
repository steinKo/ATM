package steinKo.ATM.presentaion.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

import steinKo.ATM.service.ATMService;

@WicketHomePage
public class HomePage extends WebPage {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ATMService atmService;
	TextField<String> pinAndAmount;
	TextArea<String> message;

	public HomePage() {
		Logger logger = LoggerFactory.getLogger("HomePage");
		logger.info("start Home page createor");
		Form<?> menu = new Form<Void>("menu") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				logger.info("Form.onSubmit executed");
			}
		};

		Button a = new Button("A") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				atmService.buttomAPushed(pinAndAmount.getValue());
				String atmServiceDisplay = atmService.display();
				logger.info(atmServiceDisplay);
				message.setDefaultModelObject(atmServiceDisplay);
				pinAndAmount.setDefaultModelObject("");
				logger.info("buttonA.onSubmit executed");

			}
		};
		menu.add(a);

		add(menu);

		logger.info("content form panel createor");
		Form<?> content = new Form<Void>("content") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				info("content onSubmit executed");
			}
		};

		pinAndAmount = new TextField<String>("pinAndAmount", Model.of(""));
		logger.info(pinAndAmount.toString());
		message = new TextArea<String>("message", Model.of(atmService.display()));
		logger.info(message.toString());

		final Button b1 = new Button("1") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button b3 = new Button("3") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};
		final Button b4 = new Button("4") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button b6 = new Button("6") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button b7 = new Button("7") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
				;
			}
		};

		final Button b8 = new Button("8") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
				;
			}
		};

		final Button b9 = new Button("9") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 9L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button b2 = new Button("2") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
				;
			}
		};

		final Button b5 = new Button("5") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button b0 = new Button("0") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 11L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button bComma = new Button(",") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 12L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		final Button bCE = new Button("CE") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 13L;

			@Override
			public void onSubmit() {
				String id = this.getId();
				setValue(pinAndAmount, id);
			}
		};

		content.add(b4);
		content.add(b7);
		content.add(b3);
		content.add(b2);
		content.add(b5);
		content.add(b6);
		content.add(b8);
		content.add(b9);
		content.add(pinAndAmount);
		content.add(message);
		content.add(b1);
		content.add(b0);
		content.add(bComma);
		content.add(bCE);

		add(content);
		logger.info("end home page createor");
	}

	private void setValue(final TextField<String> pinAndAmount, String id) {
		String value = (String) pinAndAmount.getDefaultModelObject();
		if (value == null)
			value = id;
		else
			value = value + id;
		pinAndAmount.setDefaultModelObject(value);
	}

}
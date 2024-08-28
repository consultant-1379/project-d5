/**
 * Component DialogsComponent is defined as
 * `<e-dialogs-component>`
 *
 * Imperatively create component
 * @example
 * let component = new DialogsComponent();
 *
 * Declaratively create component
 * @example
 * <e-dialogs-component></e-dialogs-component>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './dialogsComponent.css';
import { Dialog } from '@eds/vanilla/dialog/Dialog';
/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-dialogs-component', {
  style,
  home: 'dialogs-component',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
  },
})
export default class DialogsComponent extends LitComponent {
  /**
   * Render the <e-dialogs-component> component. This function is called each time a
   * prop changes.
   */


  didUpgrade() {
//    this._dialogs(); // loads chart out of box in app-1
  }

  _dialogs()
  {
    const dialogs = this.shadowRoot.querySelectorAll('.dialog');
    console.log("this is diaglogs",dialogs);
    if (dialogs) {
      Array.from(dialogs).forEach((dialogDOM) => {
        const dialog = new Dialog(dialogDOM);
        dialog.init();

        dialogDOM.querySelector('button.primary').addEventListener('click', () => {
          // Your code here
          console.log("clicked button");
          dialog.hide();
        });
      });
    }
  }

  render() {
    return html`<h1>Your component markup goes here</h1>
    <h2>props</h2>

    <div class="dialog" data-trigger="#open-simple" data-type="simple">
      <div class="content">
        <div class="top">
          <div class="title">Subscribe</div>
        </div>
        <div class="body">
          <p>Share your email to keep updated with the latest news.</p>
          <input type="text" class="fullwidth" placeholder="example@email.com">
          <div class="suffix icon-inside"><i class="icon icon-email"></i></div>
        </div>
        <div class="bottom">
          <button class="btn ghost" data-close="true">Cancel</button>
          <button class="btn primary">Submit</button>
        </div>
      </div>
    </div
    
    `;
  }
}

/**
 * Register the component as e-dialogs-component.
 * Registration can be done at a later time and with a different name
 */
DialogsComponent.register();

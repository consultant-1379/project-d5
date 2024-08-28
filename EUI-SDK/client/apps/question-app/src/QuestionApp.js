/**
 * QuestionApp is defined as
 * `<e-question-app>`
 *
 * Imperatively create application
 * @example
 * let app = new QuestionApp();
 *
 * Declaratively create application
 * @example
 * <e-question-app></e-question-app>
 *
 * @extends {App}
 */
import { definition } from '@eui/component';
import { App, html } from '@eui/app';
import style from './questionApp.css';

@definition('e-question-app', {
  style,
  props: {
    response: { attribute: false },
  },
})
export default class QuestionApp extends App {
  /**
   * Uncomment this block to add initialization code
   * constructor() {
   *   super();
   *   // initialize
   * }
   */

  /**
  * Render the <e-question-app> app. This function is called each time a
  * prop changes.
  */
  render() {

    return html`
    <h1 class= "h1">
      Cloud Native  Maturity Matrix Asssment Question</h1>




             <eui-layout-v0-tile tile-title="Architecure" subtitle="" column=0>
                    <div slot="content">

                         <e-lit-demo class ="questions"></e-lit-demo>

                    </div>
             </eui-layout-v0-tile>





    `;
  }
}

/**
 * Register the component as e-question-app.
 * Registration can be done at a later time and with a different name
 * Uncomment the below line to register the App if used outside the container
 */
// QuestionApp.register();

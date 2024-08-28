/**
 * Component LitDemo is defined as
 * `<e-lit-demo>`
 *
 * Imperatively create component
 * @example
 * let component = new LitDemo();
 *
 * Declaratively create component
 * @example
 * <e-lit-demo></e-lit-demo>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './litDemo.css';



global.category=["culture","prodservicedesign","team","process","architecture","maintenance","delivery","provisioning","infrastructure"];
global.index=0;
global.questionData;
const storage = window.localStorage;
    storage.setItem('refresh',0);
/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-lit-demo', {
  style,
  home: 'lit-demo',
  props: {
    q0: { attribute: true, type: Boolean, default: false },
    q1: { attribute: true, type: Boolean, default: false },
    q2: { attribute: true, type: Boolean, default: false },
    q3: { attribute: true, type: Boolean, default: false },
    q4: { attribute: true, type: Boolean, default: false },
    pValue:{ attribute: true, type: Number,default: 10 },
    common : {attribute: true,type:Array },
    proValue:{ attribute: true, type: Number,default: 20},
    questionData: { type: Object },
    checkboxStatus: { attribute: true, type: Boolean, default: true},
    cValue:{ attribute: true, type: Number,default: 0 },

  },
})


export default class LitDemo extends LitComponent {
  /**
   * Render the <e-lit-demo> component. This function is called each time a
   * prop changes.
   */

    _clear(){

          this.q1=false;
           this.q2=false;
            this.q2=false;
             this.q3=false;
             this.q4=false;

          console.log("clearing the check box ")


    }

   _didConnect(){

  const storage = window.localStorage;
  let name =storage.getItem('username');
  console.log("the name from session is",name);
  const todo = {
    category: global.category[global.index],

  };
  console.log("this is new updated cat",todo);
  fetch('http://localhost:9092/getQuestions', {
                     method: 'POST',
                     body: JSON.stringify(todo),
                     headers: { 'Content-Type': 'application/json' }
                   })

         .then((response) => {
           return response.json();
         }).then((json) => {
        global.questionData=json;

//       console.log("this is ques data",global.questionData);
//       console.log("this is json data",json);
       this.questionData=global.questionData;
//        console.log("this is this data",Object.values(this.questionData)[0]);

        this.shadowRoot.querySelector('#h1').innerText="Question:"+(global.index+1)+" "+Object.values(this.questionData)[0];
        this.shadowRoot.querySelector('#p1').innerText=Object.values(this.questionData)[1];
        this.shadowRoot.querySelector('#p2').innerText=Object.values(this.questionData)[2];
        this.shadowRoot.querySelector('#p3').innerText=Object.values(this.questionData)[3];
        this.shadowRoot.querySelector('#p4').innerText=Object.values(this.questionData)[4];



     }).catch((error) => {
       console.log('parsing failed', error);
     });
  }

   didUpgrade() {
    this._didConnect();
    this.checkboxStatus=true;

  }


  render() {


//    console.log("this is categories",global.category);
//    console.log("this is index",global.index);
//    console.log("this is selected categories",global.category[index])

    return html`

    <eui-base-v0-progress-bar buffer="30" max="100" min="0" unit="%" value="${this.proValue}" color="orange"></eui-base-v0-progress-bar>
    <h1 id="h1"><b> </b></h1>


        <p id= "p0">  </p>
        <div>
                         <br></br>

                             <eui-base-v0-button name="button3" id="button-3" @click=${this}>
                                           No
                                     </eui-base-v0-button>

                                 <eui-base-v0-button name="button4" id="button-4" @click=${this}>
                                   Yes
                                 </eui-base-v0-button>
         </div>



   <div >


    <eui-base-v0-checkbox ?disabled="${this.checkboxStatus}" name="checkbox-1" ?checked="${this.q1}" @click="${(event) => this._function_to_checkbox_1(event.currentTarget)}">

      <p id= "p1" ></p>

    </eui-base-v0-checkbox>
    <eui-base-v0-checkbox ?disabled="${this.checkboxStatus}" name="checkbox-2" ?checked="${this.q2}" @click="${(event) => this._function_to_checkbox_2(event.currentTarget)}">
    <p id= "p2"></p>>


    </eui-base-v0-checkbox>
    <eui-base-v0-checkbox ?disabled="${this.checkboxStatus}" name="checkbox-3" ?checked="${this.q3}" @click="${(event) => this._function_to_checkbox_3(event.currentTarget)}">

    <p id= "p3"></p>

    </eui-base-v0-checkbox>
    <eui-base-v0-checkbox ?disabled="${this.checkboxStatus}" name="checkbox-4" ?checked="${this.q4}" @click="${(event) => this._function_to_checkbox_4(event.currentTarget)}">

    <p id= "p4"></p>

    </eui-base-v0-checkbox>


    </div>

    <div>
    <br></br>

        <eui-base-v0-button name="button2" id="button-2" @click=${this}>
                     Previous
                </eui-base-v0-button>

            <eui-base-v0-button name="button1" id="button-1" @click=${this}>
              Next
            </eui-base-v0-button>
    </div>






    </div>
    `;
  }




  _function_to_checkbox_1(target) {

    this.q1 = !this.q1;
     if(this.q1)
     {
        this.cValue++;
     }

    // console.log(this.q1);

  }
  _function_to_checkbox_2(target) {

    this.q2 = !this.q2;

    // console.log(this.q2);

  }
  _function_to_checkbox_3(target) {

    this.q3 = !this.q3;

    // console.log(this.q4);

  }
  _function_to_checkbox_4(target) {

    this.q4 = !this.q4;

    // console.log(this.q4);

  }


  handleEvent(event) {
    switch (event.target.id) {
      case 'button-1':
        sendQuestion(this);
        break;
      case 'button-2':
        preQuestion(this);
        break;
      case 'button-3':
        ChangeHandler(this);
        console.log("this c",this.checkboxStatus);
        break;
      case 'button-4':
        leadQuestion(this);
              break;

        break;
      default:
        break;
    }
  }



}
function ChangeHandler(ex)
{
    ex.checkboxStatus =!ex.checkboxStatus;
    ex.q0=false;
    console.log("this checked");

}

function leadQuestion(ex)
{
    console.log("this is lead question");
    ex.q0=true;
    console.log("this is q0Ans",ex.q0);
    sendQuestion(ex);
}
function sendQuestion(ex) {

  const storage = window.localStorage;
  let name =storage.getItem('username');
  console.log("the name from session is",name);
  const todo = {

    teamName: name,
    category: global.category[global.index],
    q0Ans: ex.q0,
    q1Ans: ex.q1,
    q2Ans: ex.q2,
    q3Ans: ex.q3,
    q4Ans:ex.q4

  };
  console.log("this is the question ansewerd",ex.q0,ex.q1 ,ex.q2,ex.q3,ex.q4)
  console.log("this is todo",todo);
  fetch('http://localhost:9091/processAnswers', {

    method: 'POST',
    body: JSON.stringify(todo),
    headers: { 'Content-Type': 'application/json' }
  }).then(function (response) {
    return response
  }).then(function (res) {

    console.log("the result is ",res)

    if(res.status==200)
    {
         ex._clear();
         ex.checkboxStatus=true;
        const storage = window.localStorage;
        storage.setItem('refresh',0);

        if(global.index<8)
        {


         global.index++;
         ex.proValue= ex.proValue+10;
         console.log("update index",global.index)

         ex._didConnect()
         }
         else
         {
            console.log("this is last question",global.index)
            window.location = './#app-1';
            window.location.reload(1);

         }

    }


  });
}


function preQuestion(ex) {

       if(global.index!=0)
            {
                global.index--;
                ex.proValue= ex.proValue-10;
                console.log("update index",global.index)
                ex._didConnect()
            }
            else
            {
                 console.log("this is the first question")
            }


}

function getQuestion(ex) {

  const storage = window.localStorage;
  let name =storage.getItem('username');
  console.log("the name from session is",name);
  const todo = {
    category: global.category[global.index],

  };
  console.log("this is updated cat",todo);
  fetch('http://localhost:9091/processAnswers', {

    method: 'POST',
    body: JSON.stringify(todo),
    headers: { 'Content-Type': 'application/json' }
  }).then(function (response) {
    return response
  }).then(function (res) {

    console.log("the result is ",res)




  });
}

/**
 * Register the component as e-lit-demo.
 * Registration can be done at a later time and with a different name
 */
LitDemo.register();

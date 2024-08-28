/**
 * App1 is defined as
 * `<e-app-1>`
 *
 * Imperatively create application
 * @example
 * let app = new App1();
 *
 * Declaratively create application
 * @example
 * <e-app-1></e-app-1>
 *
 * @extends {App}
 */
import { definition } from '@eui/component';
import { App, html } from '@eui/app';
import '@eui/layout';
import style from './app1.css';

// import '../../../components/lit-demo/src/LitDemo';
// import '../../../components/template/src/Template';
import '../../../components/demo/src/Demo';
import '@eui/table';
global.average;
global.refresh=0;

@definition('e-app-1', {
  style,
  props: {
    response: { attribute: false },
     data: { type: Object },
    // value: { type: Array },
    // common : {type:Array},
    key: { type: Object },
    maturity:{ attribute: true ,type: String}
  },
})



export default class App1 extends App {
  /**
   * Uncomment this block to add initialization code
   * constructor() {
   *   super();
   *   // initialize
   * }
   */

  /**
  * Render the <e-app-1> app. This function is called each time a
  * prop changes.
  */
  /**
   * lifecycle hook
   * @method didUpgrade
   */


_refresh()
{
const storage = window.localStorage;


    global.refresh = storage.getItem('refresh');
    console.log("refresh",global.refresh)
    if(global.refresh<1)

    {
    setTimeout(function(){
       window.location.reload(1);
    }, 50);
    global.refresh++;
     storage.setItem('refresh',global.refresh);
    console.log("this is refresh",global.refresh)
    }


}

_didConnect(){
  const storage = window.localStorage;

  global.average =storage.getItem("average");
   console.log("this is avg",storage.getItem("average"))
   console.log("this is  global avg",global.average)
    if(global.average <1)
        {
           this.key= {"col2":"You"};
           this.maturity="No Process";
        }
        else if (global.average ==1)
        {
        console.log("hello",global.average)
           this.key= {"col3":"WaterFall"};
           this.maturity="WaterFall";
        }
        else if (global.average <1.5)
                {
                   this.key= {"col4":"less Agile"};
                   this.maturity=" Hybrid Waterfall";
                }

        else if (global.average ==1.5)
                        {
                           this.key= {"col4":"semi-Agile"};
                            this.maturity="Agile-ish";

                        }
        else if( global.average <2)

        {

          this.key= {"col4":"More Agile"};
          console.log("this is key",this.key);
          this.maturity="Hybrid Agile";
        }
        else if( global.average ==2)

                {

                  this.key= {"col5":"Agile"};
                  this.maturity="Agile";
                }
        else if( global.average <2.5)

                        {

                          this.key= {"col6":"Less Cloud-Native"};
                          this.maturity="Cloud Native-ish ";

                        }
        else if( global.average ==2.5)

                                {

                                  this.key= {"col6":"semi- Cloud-Native"};
                                  this.maturity="Semi-Cloud Native ";
                                }

        else if( global.average <3)

                {

                  this.key= {"col6":"More Cloud-Native"};
                  this.maturity="More Cloud Native ";
                }
        else if( global.average ==3)

                       {

                         this.key= {"col7":"Cloud-Native"};
                         this.maturity="Cloud Native";

                       }

        console.log("this is key",this.key);




      this.data=[  {"col2":0,"col3":1,"col4":1.5,"col5":2.0,"col6":2.5,"col7":3,"col8": 4},
                    this.key
         ] ;

      console.log("this is data",this.data)


  }

 didUpgrade() {
    this._didConnect();
    this._refresh();

  }

  render() {


    const columns = [
      { title: 'Stage', attribute: 'col1' },
      { title: 'No Process', attribute: 'col2' },
      { title: 'Waterfall', attribute: 'col3' },
      { title: 'Agile', attribute: 'col4' },
      { title: 'Cloud Native', attribute: 'col5' },
      { title: 'Next', attribute: 'col6' }
    ];

    const newcolumns = [
      { title: 'Stage', attribute: 'col1' },
      { title: 'No Process', attribute: 'col2' },
      { title: 'Waterfall', attribute: 'col3' },
      { title: 'Semi-Agile', attribute: 'col4' },
      { title: 'Agile', attribute: 'col5' },
      { title: 'Semi-CloudNative', attribute: 'col6' },
      { title: 'Cloud Native', attribute: 'col7' },
      { title: 'Next', attribute: 'col8' }
    ];




      const newdata = [
       {col1:"CULTURE",col2:"Individualist",col3:"Predictive",col4:"Iterative",col5:"Collaborative",col6:"Experimental"},
       {col1:"PROD/SVC DESIGN",col2:"Arbitary",col3:"Long-term plan",col4:"Feature Driven",col5:"Data driven",col6:"All driven"},
       {col2:"No organization",col3:"Hierachy",col4:"x-Function teams",col5:"DevOps/ SRE",col6:"Internal supply Chain",col1:"TEAM"},
       {col1:"PROCESS",col2:"Random",col3:"Waterfall",col4:"Agile",col5:"Agile+Lean",col6:"istributed"},
       {col1:"Architecure",col2:"Emergin trial and error",col3:"Tighlty Coupled",col4:"Client Server",col5:"Microservice",col6:"Function"},
       {col1:"MAINTENANCE",col2:"Response TO USER",col3:"Ad-hoc Monitoring",col4:"Alerting",col5:"Full Obeservability",col6:"Preventive Ml,AI"},
       {col1:"DELIVERY",col2:"Irregular releases",col3:"Periodic release",col4:"Countinous Integration",col5:"Countinous Delivery",col6:"Countinous Deployment"},
       {col1:"PROVISIONONG",col2:"Manual",col3:"Scripted",col4:"Config. management",col5:"Orchestration",col6:"Serverless"},
       {col1:"INFRASRUTURE",col2:"Single Server",col3:"Multi Servers",col4:"VMS",col5:"Container/Cloud",col6:"Edge Computing"},

      ];

    const objectdata = [

                           {"col2":0,"col3":1,"col4":1.5,"col5":2.0,"col6":2.5,"col7":3,"col7": 4},
                           {"col6":"hello"}

                       ] ;



    return html`


       <div class="layout__dashboard">
              <eui-layout-v0-tile tile-title="Radar Chart" subtitle="Maturiy Chart" column=0>
                <div slot="content">
                  <h1 class="radar_title">You are ${this.maturity} </h1>
                                    <e-radar-component ></e-radar-component>
                </div>
              </eui-layout-v0-tile>
              <eui-layout-v0-tile tile-title="Matrix Code" subtitle="Matrix Explanation" column=0>
                <div slot="content">
                     <eui-layout-v0-tile  subtitle="" column=0>
                                        <div slot="content">


                                        <eui-table-v0 .columns=${newcolumns} .data=${this.data}></eui-table-v0>

                                        </div>
                                 </eui-layout-v0-tile>
                </div>
              </eui-layout-v0-tile>

            </div>

        <eui-layout-v0-tile tile-title="The Matrix Table" subtitle="" column=0>
                    <div slot="content">

                        <eui-table-v0 .columns=${columns} .data=${newdata}></eui-table-v0>

                    </div>
             </eui-layout-v0-tile>

      
    `;
  }
}

/**
 * Register the component as e-app-1.
 * Registration can be done at a later time and with a different name
 * Uncomment the below line to register the App if used outside the container
 */
// App1.register();

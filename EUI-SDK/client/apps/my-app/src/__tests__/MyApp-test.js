/**
 * Integration tests for <e-my-app>
 */
import { expect } from 'chai';
import MyApp from '../MyApp';
import {
  inShadow,
  injectHTMLElement,
} from '../../../../../test/utils';

describe('MyApp Application Tests', () => {
    let container;
    let inject;
    before(() => {
      container = document.body.appendChild(document.createElement('div'));
      inject = injectHTMLElement.bind(null, container);
      window.EUI = undefined; // stub out the locale
      MyApp.register();
    });

    after(() => {
      document.body.removeChild(container);
    });

    describe('Basic application setup', () => {
      it('should create a new <e-my-app>', async () => {
        const appUnderTest = await inject('<e-my-app></e-my-app>');
        // check shadow DOM
        const headingTag = inShadow(appUnderTest, 'h1');
        expect(headingTag.textContent, '"Your app markup goes here" was not found').to.equal('Your app markup goes here');
      });
    });
});

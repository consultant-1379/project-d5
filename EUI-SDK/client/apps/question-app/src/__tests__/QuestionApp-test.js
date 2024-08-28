/**
 * Integration tests for <e-question-app>
 */
import { expect } from 'chai';
import QuestionApp from '../QuestionApp';
import {
  inShadow,
  injectHTMLElement,
} from '../../../../../test/utils';

describe('QuestionApp Application Tests', () => {
    let container;
    let inject;
    before(() => {
      container = document.body.appendChild(document.createElement('div'));
      inject = injectHTMLElement.bind(null, container);
      window.EUI = undefined; // stub out the locale
      QuestionApp.register();
    });

    after(() => {
      document.body.removeChild(container);
    });

    describe('Basic application setup', () => {
      it('should create a new <e-question-app>', async () => {
        const appUnderTest = await inject('<e-question-app></e-question-app>');
        // check shadow DOM
        const headingTag = inShadow(appUnderTest, 'h1');
        expect(headingTag.textContent, '"Your app markup goes here" was not found').to.equal('Your app markup goes here');
      });
    });
});

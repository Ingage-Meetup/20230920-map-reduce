import { beforeEach, expect, test } from '@jest/globals';
import { Kata } from "./kata";

let fixture: Kata;

beforeEach(() => {
    fixture = new Kata();
});

test('hello should return message with specified name', () => {
    const name = 'Ingage';
    expect(fixture.hello(name)).toEqual(`Hello ${name}`);
});

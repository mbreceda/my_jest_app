import {isImage} from "../isImage";

describe("Test isImage function", () => {
    it('should return true if a filename is an image', () => {
        const png = isImage('picture.png');
        expect(png).toBe(true);
    })

    it('should return false if a filename is not an image', () => {
        const png = isImage('picture.md');
        expect(png).toBe(false);
    })
})
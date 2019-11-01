import { CourseDetails } from './course-details';

describe('CourseDetails', () => {
  it('should create an instance', () => {
    expect(new CourseDetails('English',2)).toBeTruthy();
  });
});

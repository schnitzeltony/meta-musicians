SUMMARY = "Programming language for audio synthesis and algorithmic composition"
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "gitsm://github.com/supercollider/supercollider.git;branch=develop"
SRCREV = "206f24d865efa37264a0b42594f536ed834c1493"
PV = "3.11.2"
S = "${WORKDIR}/git"

inherit cmake_qt5 features_check mime mime-xdg

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    qttools-native qttools \
    qtbase \
    qtwebengine \
    qtsvg \
    fftw \
    jack \
    libsndfile1 \
    alsa-lib \
    libxt \
"

SIMD_OPTIONS ??= " \
    -DSSE=OFF \
    -DSSE2=OFF \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE="Release" \
    -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} \
    -DBUILD_TESTING=OFF \
    -DENABLE_TESTSUITE=OFF \
    -DNATIVE=OFF \
    ${SIMD_OPTIONS} \
    -DSC_EL=OFF \
"

PACKAGES =+ "${PN}-gedit-plugin"

FILES:${PN} += " \
    ${datadir}/gtksourceview-3.0 \
    ${datadir}/mime \
    ${datadir}/SuperCollider \
    ${libdir}/SuperCollider/plugins/*.so \
"
INSANE_SKIP:${PN} = "useless-rpaths"

FILES:${PN}-gedit-plugin = " \
    ${libdir}/gedit \
"
